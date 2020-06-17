# Event-Thread-Practice

- 스네이크 게임을 만들면서 가장 많이 삽질한 부분에 대해 따로 정리한 프로젝트입니다.



### Thread란?

- Event-Thread를 논하기 전에 Thread 개념부터 잡고가야할 필요가 있음

- 동작하고 있는 프로그램에 프로세스라고 한다. 보통 하나의 프로세스는 하나의 작업을 하지만, thread를 이용하면 두가지 이상의 일을 할 수 있다.

- 하나의 프로세스 내부에서 독립적으로 실행되는 하나의 작업 단위, 세부적으로는 운영체제에 의해 관리 되는 하나의 작업을 말한다.

- 쉽게 표현하면 우리가 자바 프로그램을 실행한다면 JVM에 의해 프로그램이 돌아간다. 여기서 JVM에 의해 프로그램이 돌아가는 것이 프로세스이고, 그 프로세스를 돌아가게끔 만드는 main 함수가 하나의 thread이다.

- 내가 이해하기 쉽게 표현하면 프로세스는 연구실이고 스레드는 연구원이다.

- 즉 프로세스 안에서 열심히 일하는 하나의 작업자라고 보면 이해하기 쉬울 것 같다.

- 기본적으로 자바에서 main 함수를 호출하면 JVM의 의해 main thread가 생성된다. 추가적으로 thread를 사용하고 싶으면 따로 생성해주면 된다.

- 따로 생성한 thread는 순서와 상관없이 랜덤하게 호출되고 종료된다.

- 멀티 스레드에서 스레드의 순서를 보장하기 위해 Thread.join 함수를 지원해준다.

- 아래의 코드는 Thread 클래스를 상속받아 10개의 Thread를 생성하고 호출하는 코드이다.

  

```java
public class ThreadTest extends Thread{

    public void run() {
        System.out.println(Thread.currentThread().getName() + "thread run");

        try {
            Thread.sleep(5000);
        } catch(Exception e) {

        }

        System.out.println(Thread.currentThread().getName()  + "thread end");
    }

    public static void main(String[] args) {
        for (int i = 0; i<10; i++) {
            new ThreadTest().start();
        }

        System.out.println("main end");
    }
}


```

- 실행할때 마다 달라지겟지만 위에 코드를 실행해보면 아래와 같은 결과를 얻을 수 있을 것이다.

Thread-0thread run
Thread-3thread run
Thread-4thread run
Thread-2thread run
Thread-1thread run
Thread-5thread run
Thread-6thread run
Thread-7thread run
main end
Thread-8thread run
Thread-9thread run
Thread-2thread end
Thread-0thread end
Thread-8thread end
Thread-5thread end
Thread-4thread end
Thread-9thread end
Thread-6thread end
Thread-7thread end
Thread-1thread end
Thread-3thread end

### Thread Join

- 위 코드를 보면 쓰레드가 모두 수행되고 종료되기 전에 main 메소드가 먼저 종료되어 버렸다.
- main 메소드가 종료되기 전에 쓰레드를 종료시키는 방법은 없을까 라는 생각도 할 수도 있다.

```java
public class ThreadTest2 implements Runnable{


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " thread start.");
        try {
            Thread.sleep(1000);
        }catch(Exception e) {
        }
        System.out.println(Thread.currentThread().getName() + " thread end.");
    }

    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<Thread>();
        for(int i=0; i<10; i++) {
            Thread t = new Thread(new ThreadTest2());
            t.start();
            threads.add(t);
        }

        for(int i=0; i<threads.size(); i++) {
            Thread t = threads.get(i);
            try {
                t.join();
            }catch(Exception e) {
            }
        }
        System.out.println("main end.");
    }

}
```

- 실행 결과를 보면 main 메소드가 끝나기전에 모든 쓰레드가 종료되는 것을 볼 수 있다.

Thread-1 thread start.
Thread-5 thread start.
Thread-4 thread start.
Thread-2 thread start.
Thread-7 thread start.
Thread-0 thread start.
Thread-3 thread start.
Thread-8 thread start.
Thread-6 thread start.
Thread-9 thread start.
Thread-4 thread end.
Thread-2 thread end.
Thread-0 thread end.
Thread-8 thread end.
Thread-5 thread end.
Thread-1 thread end.
Thread-9 thread end.
Thread-6 thread end.
Thread-3 thread end.
Thread-7 thread end.
main end.

[출처 : 점프 투 자바](https://wikidocs.net/230)



### Event Dispatch Thread (EDT)

- Swing 컴포넌트의 UI 상태를 변경하는 것은 Event Dispatch Thread는 단일 스레드 체계에 의해 관리가 된다.
- 즉,  Move-Pratice2 프로젝트에서 KeyListener와 ActionListener를 동시에 사용할 수 없다는 이야기이다..
- GUI 응용 프로그램을 사용할 때 버튼을 누른다든가, 마우스를 이동을 한다. 통상 이러한 동작들에 대해 GUI 프로그램이 처리 되면 우리는 흔히 이벤트가 발생했다라고 말한다
- 그냥 한마디로 사용자가 마우스를 움직이든, 키보드를 누르던 그것을 다 이벤트라고 칭한다.
- 이 사실을 조금만 더 빨리 알았다면 삽질을 덜 했을탠대..(삽질의 장단점)
- 대략적으로 정리한 것이고, 아직 이해가 되지 않은 부분이 많다...



