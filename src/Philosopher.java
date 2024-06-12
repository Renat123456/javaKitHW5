public class Philosopher extends Thread{
    private String name;
    private boolean forkOnTable = true;
    private Philosopher philosopherNearby;
    private int countEat = 0;
    private boolean successively = false;

    public Philosopher(String name) {
        this.name = name;
    }

    public Philosopher(String name, Philosopher philosopherNearby) {
        this.name = name;
        this.philosopherNearby = philosopherNearby;
    }

    public void setPhilosopherNearby(Philosopher philosopherNearby) {
        this.philosopherNearby = philosopherNearby;
    }

    public boolean getFork() {
        return forkOnTable;
    }

    public void setFork() {
        this.forkOnTable = !this.forkOnTable;
    }

    @Override
    public void run() {
        while (countEat < 3){
            try {
                eat();
                reflect();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void reflect() throws InterruptedException {
        sleep(1000);
        successively = false;
    }

    public void eat() throws InterruptedException {
        if(getFork() && philosopherNearby.getFork() && countEat < 3 && !successively){
            countEat++;
            setFork();
            philosopherNearby.setFork();
            System.out.println(name + " ест " + countEat + " раз");
            sleep(1000);
            setFork();
            philosopherNearby.setFork();
            successively = true;
        }
    }
}
