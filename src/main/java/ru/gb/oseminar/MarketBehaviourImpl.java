package ru.gb.oseminar;

import java.util.List;

public class MarketBehaviourImpl implements  MarketBehaviour {

    private final QueueBehaviour queueBehaviour;

    public MarketBehaviourImpl(QueueBehaviourImpl queueBehaviour) {
        this.queueBehaviour = queueBehaviour;
    }

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + " пришел в магазин");
        this.queueBehaviour.takeInQueue(actor);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for(Actor actor: actors){
            System.out.println(actor.getName() + " вышел из магазина");
            this.queueBehaviour.releaseFromQueue(actor);
        }
    }

    @Override
    public void update() {
        this.queueBehaviour.takeOrders();
        this.queueBehaviour.giveOrders();
        this.queueBehaviour.releaseFromQueue();
    }
}
