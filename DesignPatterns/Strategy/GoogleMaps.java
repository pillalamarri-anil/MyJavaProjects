package DesignPatterns.Strategy;

public class GoogleMaps {
        void findPathByMode(TravelMode travelMode) {
            PathCalcStrategy p = PathCalStrategyFactory.createPathCalculator(travelMode);
            p.findPath();
        }
}
