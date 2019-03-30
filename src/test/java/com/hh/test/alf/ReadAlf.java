package com.hh.test.alf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXB;

import com.hh.test.pojo.diagnostics.Log;
import com.hh.test.pojo.diagnostics.Message;
import com.hh.test.pojo.diagnostics.Record;
import com.hh.test.util.UUIDRadom;

public class ReadAlf {

	public static void main(String[] args) throws FileNotFoundException {

		Log log = new Log();
		String xmlPath = "C:\\Users\\smg\\Desktop\\20171229\\20171229.alf";
		log = JAXB.unmarshal(new FileInputStream(xmlPath), Log.class);
		// FileReadUtils.txt2String(new
		// File("C:\\Users\\smg\\Desktop\\StudioD-1-AMSIntegrationService-20171229.002149.00.alf"));

		List<Record> records = log.getRecords();
		List<Message> messages = new ArrayList<>();
		for (Record record : records) {
			if (record.getMessage().contains("Limits")) {
				String message = record.getMessage();
				String[] messageSplit = message.split(",");
				Message msg = new Message();
				msg.setId(messageSplit[0].substring(messageSplit[0].indexOf(":")+2));
				msg.setLimits(messageSplit[1].substring(messageSplit[1].indexOf(":")+2));
				msg.setMarks(messageSplit[2].substring(messageSplit[2].indexOf(":")+2));
				msg.setDuration(messageSplit[3].substring(messageSplit[3].indexOf(":")+2));
				msg.setHostName(record.getHostname());
//				msg.setTime(record.getSyncdate());
				messages.add(msg);

			}
		}
		System.out.println(messages);

	}
}
