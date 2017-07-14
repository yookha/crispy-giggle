/*
 * HamsterAPIClientOpenCVImageExample.cpp
 *
 *  Created on: Jul 21, 2016
 *      Author: ofir
 */

#include <HamsterAPIClientCPP/Hamster.h>

int main(int argc, char ** argv)
{
	try
	{
		HamsterAPI::Hamster hamster(1);

		cv::namedWindow("Example_OpenCV");
		while(hamster.isConnected())
		{
			try
			{
				// Get Camera Image and convert it to OpenCV
				HamsterAPI::Image cameraImage = hamster.getCameraImage();
				cv::Mat mat = cameraImage.toCVMat();

				// Show Image
				cv::imshow("Example_OpenCV",mat);
				cv::waitKey(1);

			}
			catch(const HamsterAPI::HamsterError & message_error)
			{
				HamsterAPI::Log::i("Client", message_error.what());
			}
		}
	}
	catch(const HamsterAPI::HamsterError & connection_error)
	{
		HamsterAPI::Log::i("Client",connection_error.what());
	}
}

