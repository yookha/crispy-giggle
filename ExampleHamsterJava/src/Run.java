
import com.cogniteam.HamsterAPIClient.Hamster;
import com.cogniteam.HamsterAPICommon.Common.HamsterError;
import com.cogniteam.HamsterAPICommon.Common.Log;
import com.cogniteam.HamsterAPICommon.Messages.GPS;
import com.cogniteam.HamsterAPICommon.Messages.IMU;
import com.cogniteam.HamsterAPICommon.Messages.Image;
import com.cogniteam.HamsterAPICommon.Messages.LidarScan;
import com.cogniteam.HamsterAPICommon.Messages.Pose;

public class Run 
{
	public static void main(String[] args) 
	{
		try
		{
			Hamster hamster = new Hamster(1);
			while(hamster.isConnected())
			{
				try
				{
					GPS gps = hamster.getGPS();
					IMU imu = hamster.getIMU();
					LidarScan lidar = hamster.getLidarScan();
					Pose pose = hamster.getPose();
					Image image = hamster.getCameraImage();

					Log.i("Client",gps.toString());
					Log.i("Client",imu.toString());
					Log.i("Client",lidar.toString());
					Log.i("Client",pose.toString());
					Log.i("Client",image.toString());
				}
				catch(HamsterError message_error)
				{
					Log.i("Client",message_error.what());
				}
			}
		}
		catch(HamsterError connection_error)
		{
			Log.i("Client",connection_error.what());
		}
	}
}
