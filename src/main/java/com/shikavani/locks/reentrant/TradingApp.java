package com.shikavani.locks.reentrant;

import javafx.animation.AnimationTimer;
import javafx.animation.FillTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableNumberValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Map;
import java.util.Random;

public class TradingApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Cryptocurrency Trading App");

        GridPane grid = createGrid();
        Map<String, Label> cryptoLabels =createCryptoPriceLabels();

        addLabelsToGrid(cryptoLabels, grid);

        double width = 300;
        double height = 250;

        StackPane root = new StackPane();

        Rectangle background = createBackgroundRectangleWithAnimation(width, height);

        root.getChildren().add(background);
        root.getChildren().add(grid);

        primaryStage.setScene(new Scene(root, width, height));

        PriceContainer priceContainer = new PriceContainer();

        Thread priceUpdaterThread = new Thread(new PriceUpdater(priceContainer, new Random()));

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (priceContainer.getLock().tryLock()) {

                    try {
                        Label bitcoin = cryptoLabels.get("BTC");
                        bitcoin.setText(String.valueOf(priceContainer.getBitcoinPrice()));

                        Label ether = cryptoLabels.get("ETH");
                        ether.setText(String.valueOf(priceContainer.getEtherPrice()));

                        Label ripple = cryptoLabels.get("XRP");
                        ripple.setText(String.valueOf(priceContainer.getRipplePrice()));

                    } finally {
                        priceContainer.getLock().unlock();
                    }
                }
            }
        };

        addWindowResizeListener(primaryStage, background);
        animationTimer.start();
        priceUpdaterThread.setName("PriceUpdater");
        priceUpdaterThread.start();
        primaryStage.show();
    }

    private void addLabelsToGrid(Map<String, Label> cryptoLabels, GridPane grid) {

        grid.add(new Label("BTC"), 0, 0);
        grid.add(cryptoLabels.get("BTC"), 1, 0);

        grid.add(new Label("ETH"), 0, 1);
        grid.add(cryptoLabels.get("ETH"), 1, 1);

        grid.add(new Label("XRP"), 0, 2);
        grid.add(cryptoLabels.get("XRP"), 1, 2);
    }

    private Map<String, Label> createCryptoPriceLabels() {
        Label bitcoin = new Label("0");
        bitcoin.setId("BTC");
        Label ether = new Label("0");
        ether.setId("ETH");
        Label ripple = new Label("0");
        ripple.setId("XRP");

        return Map.of(
                "BTC", bitcoin,
                "ETH", ether,
                "XRP", ripple
        );
    }

    private GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        return grid;
    }

    private Rectangle createBackgroundRectangleWithAnimation(double width, double height) {
        Rectangle background = new Rectangle(width,height);
        FillTransition fillTransition = new FillTransition(Duration.millis(1000), background, Color.LIGHTCYAN, Color.LIGHTGREEN);
        fillTransition.setCycleCount(Timeline.INDEFINITE);
        fillTransition.setAutoReverse(true);
        fillTransition.play();
        return background;
    }

    private void addWindowResizeListener(Stage stage, Rectangle background) {

        ChangeListener<Number> stageSizeListener = (observable, oldValue, newValue) -> {
            background.setHeight(stage.getHeight());
            background.setWidth(stage.getWidth());
        };

        stage.widthProperty().addListener(stageSizeListener);
        stage.heightProperty().addListener(stageSizeListener);
    }


}
