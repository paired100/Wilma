import com.epam.wilma.domain.http.WilmaHttpRequest;
import com.epam.wilma.domain.stubconfig.dialog.condition.checker.ConditionChecker;
import com.epam.wilma.domain.stubconfig.parameter.ParameterList;

public class InvalidInterfaceExternalResponseFormatter implements ConditionChecker {

    @Override
    public boolean checkCondition(final WilmaHttpRequest request, final ParameterList parameters) {
        return false;
    }
}
