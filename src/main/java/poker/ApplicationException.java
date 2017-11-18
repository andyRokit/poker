package poker;

import org.springframework.boot.ExitCodeGenerator;

public class ApplicationException extends RuntimeException implements ExitCodeGenerator {

    public ApplicationException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

    @Override
    public int getExitCode() {
        return 10;
    }

}
