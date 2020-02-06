import com.greeting.Salutation;
import com.spanish.Spanish;

module spanish {
  requires greeting;
  provides Salutation with Spanish;
}