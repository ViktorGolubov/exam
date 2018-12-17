package tech.bts.exam.service;

import org.springframework.stereotype.Service;
import tech.bts.exam.model.Counter;

@Service
public class CounterService {

    private Counter counter;

    public CounterService() {
        this.counter = new Counter(0);

    }

    public void incrementCounter(int value) {

        counter.setCounter(counter.getCounter() + value);

    }

    public Counter getCounter() {

        return counter;
    }
}
