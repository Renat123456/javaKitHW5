//Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
//        Вилки лежат на столе между каждой парой ближайших философов.
//        Каждый философ может либо есть, либо размышлять.
//        Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
//        Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
//        Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза

public class Main {
    public static void main(String[] args) {
        Philosopher philosopher1 = new Philosopher("Иван");
        Philosopher philosopher2 = new Philosopher("Петр", philosopher1);
        Philosopher philosopher3 = new Philosopher("Паша", philosopher2);
        Philosopher philosopher4 = new Philosopher("Саша", philosopher3);
        Philosopher philosopher5 = new Philosopher("Миша", philosopher4);
        philosopher1.setPhilosopherNearby(philosopher5);

        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
        philosopher4.start();
        philosopher5.start();
    }
}