package de.seuhd.observer;

public class ConcreteObserver implements Observer {
    private static int observerCounter = 0;
    private int observerId;
    private Subject subject;

    public ConcreteObserver(Subject subject) {
        this.subject = subject;
        this.observerId = ++observerCounter;
        subject.attach(this);
    }

    @Override
    public void update(Subject subject) {
        if (subject instanceof ConcreteSubject) {
            ConcreteSubject concreteSubject = (ConcreteSubject) subject;
            System.out.println("Observer " + observerId + " received update from subject : New value is " + concreteSubject.getValue());
        }
    }

    public void detach() {
        subject.detach(this);
    }
}
