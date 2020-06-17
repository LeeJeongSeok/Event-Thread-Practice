# Event-Thread-Practice

- 스네이크 게임을 만들면서 가장 많이 삽질한 부분에 대해 따로 정리한 프로젝트입니다.



### Thread란?

- Event-Thread를 논하기 전에 Thread 개념부터 잡고가야할 필요가 있음
- 하나의 프로세스 내부에서 독립적으로 실행되는 하나의 작업 단위, 세부적으로는 운영체제에 의해 관리 되는 하나의 작업을 말한다.
- 쉽게 표현하면 우리가 자바 프로그램을 실행한다면 JVM에 의해 프로그램이 돌아간다. 여기서 JVM에 의해 프로그램이 돌아가는 것이 프로세스이고, 그 프로세스를 돌아가게끔 만드는 main 함수가 하나의 thread이다.
- 내가 이해하기 쉽게 표현하면 프로세스는 연구실이고 스레드는 연구원이다.

### Event Dispatch Thread (EDT)

- Swing 컴포넌트의 UI 상태를 변경하는 것은 Event Dispatch Thread(이하 EDT) 라는 단일 스레드 체계에 의해 관리가 된다.
- 즉,  Move-Pratice2 프로젝트에서 KeyListener와 ActionListener를 동시에 사용할 수 없다는 이야기이다..
- GUI 응용 프로그램을 사용할 때 버튼을 누른다든가, 마우스를 이동을 한다. 통상 이러한 동작들에 대해 GUI 프로그램이 처리 되면 우리는 흔히 이벤트가 발생했다라고 말한다
- 그냥 한마디로 사용자가 마우스를 움직이든, 키보드를 누르던 그것을 다 이벤트라고 칭한다.



