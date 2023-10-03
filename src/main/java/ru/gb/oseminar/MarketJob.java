package ru.gb.oseminar;

import java.util.ArrayList;
import java.util.List;

public class MarketJob {
    private final List<Actor> queue;
    private final MarketBehaviour marketBehaviour;
    private final Market market;

    public MarketJob() {
        this.queue = new ArrayList<>();
        this.marketBehaviour = new MarketBehaviourImpl(new QueueBehaviourImpl(this.queue));

        this.market = new MarketImpl(marketBehaviour);

        Human human1 = new Human("Ivan");
        Human human2 = new Human("Vladimir");

        marketBehaviour.acceptToMarket(human1);
        marketBehaviour.acceptToMarket(human2);

        market.update();
    }

    public static void main(String[] args) {
       new MarketJob();
    }
}
