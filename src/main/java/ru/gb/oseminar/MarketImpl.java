package ru.gb.oseminar;

import java.util.List;

public class MarketImpl implements Market {
    private final MarketBehaviour marketBehaviour;

    public MarketImpl(MarketBehaviour marketBehaviour){
        this.marketBehaviour = marketBehaviour;
    }

    @Override
    public void acceptToMarket(Actor actor) {
        this.marketBehaviour.acceptToMarket(actor);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        this.marketBehaviour.releaseFromMarket(actors);
    }

    @Override
    public void update() {
        this.marketBehaviour.update();
    }
}
