package ru.gb.oseminar;

import java.util.ArrayList;
import java.util.List;

public class QueueBehaviourImpl implements  QueueBehaviour {

    private final List<Actor> queue;

    public QueueBehaviourImpl(List<Actor> queue) {
        this.queue = queue;
    }

    @Override
    public void takeInQueue(Actor actor) {
        System.out.println(actor.getName() + " встал в очередь");
        this.queue.add(actor);
    }

    @Override
    public void takeOrders() {
        for(Actor actor: queue){
            if(!actor.isMakeOrder()){
                actor.setMakeOrder(true);
                System.out.println(actor.getName() + " сделал свой заказ");
            }
        }
    }

    @Override
    public void giveOrders() {
        for(Actor actor: queue){
            if(actor.isMakeOrder()){
                actor.setTakeOrder(true);
                System.out.println(actor.getName() + " получил свой заказ");
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> releasedActors = new ArrayList<>();
        for(Actor actor: queue){
            if(actor.isTakeOrder()){
                releasedActors.add(actor);
                System.out.println(actor.getName() + " вышел из очереди и готов уходить");
            }
        }
    }

    @Override
    public void releaseFromQueue(Actor actor) {
        if(actor.isTakeOrder()){
            queue.remove(actor);
            System.out.println(actor.getName() + " вышел из очереди и готов уходить");
        }
    }
}
