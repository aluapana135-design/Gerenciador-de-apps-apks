import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PackageManager pm = getPackageManager();
        // Lista todos os aplicativos instalados, inclusive do sistema
        List<PackageInfo> packages = pm.getInstalledPackages(PackageManager.GET_PERMISSIONS);

        for (PackageInfo packageInfo : packages) {
            String appName = packageInfo.applicationInfo.loadLabel(pm).toString();
            String packageName = packageInfo.packageName;

            System.out.println("App: " + appName);
            System.out.println("Pacote: " + packageName);

            // Lista as permissões pedidas pelo app
            String[] permissions = packageInfo.requestedPermissions;
            if (permissions != null) {
                System.out.println("Permissões:");
                for (String perm : permissions) {
                    System.out.println(" - " + perm);
                }
            } else {
                System.out.println("Este app não pediu permissões.");
            }

            System.out.println("------------");
        }
    }
}