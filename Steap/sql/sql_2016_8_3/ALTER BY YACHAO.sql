﻿ALTER TABLE specialist_evaluation DROP reviewId;
ALTER TABLE specialist_evaluation ADD PRIMARY KEY(specialistId, projectId);

ALTER TABLE evaluation_result ADD UNIQUE(projectId);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100005', 'P1000004', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100011', 'P1000003', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'P1000006', 'P1000007', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100002', 'P1000002', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SL100010', 'P1000003', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SL100003', 'P1000009', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100014', 'P1000005', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100008', 'P1000008', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'P1000006', 'P1000008', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100019', 'P1000010', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100004', 'P1000001', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100001', 'P1000003', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100002', 'P1000010', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100012', 'P1000001', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SL100006', 'P1000010', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100006', 'P1000005', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100009', 'P1000006', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SL100003', 'P1000010', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100017', 'P1000002', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100019', 'P1000009', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SL100006', 'P1000009', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100015', 'P1000008', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'P1000006', 'P1000006', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SL100010', 'P1000001', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100015', 'P1000007', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100009', 'P1000007', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100008', 'P1000007', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100008', 'P1000006', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100006', 'P1000004', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'P1000007', 'P1000008', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100011', 'P1000001', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100019', 'P1000002', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SL100002', 'P1000003', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100002', 'P1000009', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100005', 'P1000005', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100017', 'P1000009', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SL100002', 'P1000001', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SL100006', 'P1000002', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100012', 'P1000003', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SL100010', 'P1000005', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SL100003', 'P1000002', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100001', 'P1000001', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'P1000007', 'P1000006', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100015', 'P1000006', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100014', 'P1000004', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100013', 'P1000005', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SL100010', 'P1000004', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'P1000007', 'P1000007', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100009', 'P1000008', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100004', 'P1000003', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100013', 'P1000004', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);
INSERT INTO `specialist_evaluation` VALUES ( 'SR100017', 'P1000010', '该项目验收资料基本合格，但存在以下问题：<br>1、没有提供财务证明<br> 2、需要提供论文复印件', null);

