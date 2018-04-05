package com.thinkPro.steap.test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thinkPro.steap.common.List2Array;
import com.thinkPro.steap.db.service.project.ProjectService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class ExportUtilTest {
	
	@Resource
	private ProjectService projectService;
	
	@Test
	public void exportUtilTest() {
		try {
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("status", "已发放证书");
			List<Map<String, Object>> projects = projectService.getAllProjectsNoPaging(condition);
			
			System.out.println("=======================================");
			String[] headerAlias = {"projectId", "projectName", "applicant", "domain", "recordDate", "checkDate", "certificate", "projectStatus"};
			Object[][] projectArray = List2Array.convert(headerAlias, projects);
			for (int i = 0; i < projectArray.length; i++) {
				for (int j = 0; j < projectArray[i].length; j++) {
					System.out.print(projectArray[i][j] + "\t");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
