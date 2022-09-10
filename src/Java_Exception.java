public class Java_Exception {

    public static void main(String[] args) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            // InterruptedException 은 checked exception 이므로 try-catch 문을 제거하면 컴파일 오류가 발생한다.
            // 예외 처리
        }
    }

}
