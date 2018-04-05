package cn;

import ws.qlq.a.JobService;
import ws.qlq.a.JobServiceImplService;

public class JobServiceTest {

	public static void main(String[] args) {
		JobServiceImplService jobServiceImplService = new JobServiceImplService();
		JobService jobServiceImplPort = jobServiceImplService.getJobServiceImplPort();
		String job = jobServiceImplPort.getJob();
		String [] jobs =job.split("\\|");
		for (String s:jobs){
			System.out.println(s);
		}
	}
}
