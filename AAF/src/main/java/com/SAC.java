import com.Planner.*;
import com.SACInstance.*;
import com.Operators.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.AssessmentMetric.*;

public class SAC {
    public static void main(String[] args) {
        MAPE mape = new MAPE();
        mape.MAPE_response(args[0], args[1]);
    }
}



