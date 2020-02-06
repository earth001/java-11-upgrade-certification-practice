import com.english.English;
import com.greeting.Salutation;

module english {
  requires greeting;
  provides Salutation with English;
}