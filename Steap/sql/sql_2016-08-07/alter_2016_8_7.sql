TRUNCATE TABLE project_material;

ALTER TABLE evaluation_result ADD COLUMN checkDate DATE not null;
UPDATE evaluation_result SET checkDate='2016-08-04';

ALTER TABLE project_material ADD UNIQUE(fileId);
INSERT INTO `project_material` VALUES ('08734fbe-8154-4cea-9cad-b0bf1f3f6649', 'P1000002', '13');
INSERT INTO `project_material` VALUES ('1366e648-4864-4d0d-94d8-2df8e1505bd6', 'P1000003', '19');
INSERT INTO `project_material` VALUES ('1412f780-a84d-4155-8b88-5bb63990c1bc', 'P1000005', '46');
INSERT INTO `project_material` VALUES ('14170792-2bfc-4cf3-8b0f-e4d0d977fb84', 'P1000004', '29');
INSERT INTO `project_material` VALUES ('1e9e38f4-c614-4d97-a9ad-92257e8ef512', 'P1000003', '20');
INSERT INTO `project_material` VALUES ('22687522-a6a1-4d6b-8a86-847be93726f9', 'P1000001', '7');
INSERT INTO `project_material` VALUES ('2d357c64-42d7-42d3-b340-cc5723b4dc9d', 'P1000003', '24');
INSERT INTO `project_material` VALUES ('3692f58e-2153-4c53-ab00-ae587f99b09b', 'P1000002', '9');
INSERT INTO `project_material` VALUES ('3a62a3c3-31a3-483f-a2d4-330285107575', 'P1000001', '1');
INSERT INTO `project_material` VALUES ('3b755d9a-c01d-4da3-821f-18ec2b79518c', 'P1000001', '2');
INSERT INTO `project_material` VALUES ('3d81fb1c-f78f-4e35-b700-545cfd439343', 'P1000001', '8');
INSERT INTO `project_material` VALUES ('3edac148-da1a-442c-8834-9f2b76d42d17', 'P1000005', '42');
INSERT INTO `project_material` VALUES ('59108551-9035-4419-ba56-90d2f9fc3ada', 'P1000003', '21');
INSERT INTO `project_material` VALUES ('5fa1aef4-24ed-4bb9-a669-6d373dfc5759', 'P1000005', '40');
INSERT INTO `project_material` VALUES ('65fade38-afe2-4faa-bcc8-1e5bd050555b', 'P1000001', '4');
INSERT INTO `project_material` VALUES ('6a285dd1-ba13-4e32-9fda-313d47344b14', 'P1000002', '16');
INSERT INTO `project_material` VALUES ('703e59a1-d47f-43d2-b46a-106d95bf29d9', 'P1000001', '6');
INSERT INTO `project_material` VALUES ('74926aa7-318b-49de-85ff-671f353db7ac', 'P1000005', '41');
INSERT INTO `project_material` VALUES ('86160c7b-9ba8-4388-88a1-fbc0050b3965', 'P1000004', '33');
INSERT INTO `project_material` VALUES ('87fbba99-d39f-4bab-a551-0c3802a554e8', 'P1000005', '43');
INSERT INTO `project_material` VALUES ('89b2677f-2ffc-4fd7-a72e-a2fd9a035330', 'P1000005', '44');
INSERT INTO `project_material` VALUES ('8bf70027-d1f3-4b55-a4b8-d2aab6f2cecf', 'P1000002', '14');
INSERT INTO `project_material` VALUES ('9a3c1f6f-064a-40e6-9e10-18c37cbc6b85', 'P1000004', '31');
INSERT INTO `project_material` VALUES ('9c1225ad-9f3f-4290-a55a-3766f85087fe', 'P1000005', '45');
INSERT INTO `project_material` VALUES ('a7c3e1da-fb07-483f-bea9-b97103ef9852', 'P1000004', '36');
INSERT INTO `project_material` VALUES ('ad6412dc-1c5f-4065-9d8e-a25d06e2fb12', 'P1000004', '30');
INSERT INTO `project_material` VALUES ('ae0c724b-72bc-4d64-8477-61ac1eb537ea', 'P1000002', '10');
INSERT INTO `project_material` VALUES ('ce3a2eea-d953-4c80-91b8-b253cecc8320', 'P1000003', '26');
INSERT INTO `project_material` VALUES ('dc46ccd1-d146-410c-911c-bee22fb8ba6d', 'P1000004', '34');
INSERT INTO `project_material` VALUES ('ddb10714-7f15-4850-98f6-440963ee4fac', 'P1000004', '35');
INSERT INTO `project_material` VALUES ('e431093a-8f1a-4ffa-a735-c213a84d85cb', 'P1000002', '12');
INSERT INTO `project_material` VALUES ('ea285880-1bdc-470c-a2f5-f12620056b64', 'P1000002', '15');
INSERT INTO `project_material` VALUES ('ebee2e4f-34c8-4779-9e70-02cb2cab6856', 'P1000001', '5');
INSERT INTO `project_material` VALUES ('ecdd67c7-fa8e-40b4-90cc-07074ee35fb7', 'P1000003', '25');
INSERT INTO `project_material` VALUES ('f36db3c5-2f2d-497d-8058-f15d9e90b351', 'P1000001', '3');
INSERT INTO `project_material` VALUES ('f5b8d9bb-2eda-4c0f-9475-8ab0a7c8f3c6', 'P1000002', '11');
INSERT INTO `project_material` VALUES ('f6fdc400-4f07-459f-b7cc-31cfd8fe7ba5', 'P1000003', '23');
INSERT INTO `project_material` VALUES ('f79232a6-53ff-420d-ab7a-924a4c7d65bb', 'P1000003', '22');
INSERT INTO `project_material` VALUES ('fb79f196-8b1a-4f36-9018-1f6d9837ee1d', 'P1000005', '39');
INSERT INTO `project_material` VALUES ('fd105421-b711-4c78-84a3-74adf638e59a', 'P1000004', '32');

INSERT INTO project_material VALUES('d5ea89b8-949c-47f9-8a01-b827c5639afe', 'P1000009', '47');
INSERT INTO project_material VALUES('d5ea89b8-949c-47f9-8a01-b827c5639af1', 'P1000009', '48');
INSERT INTO project_material VALUES('d5ea89b8-949c-47f9-8a01-b827c5639af2', 'P1000009', '49');
INSERT INTO project_material VALUES('d5ea89b8-949c-47f9-8a01-b827c5639af3', 'P1000009', '50');
INSERT INTO project_material VALUES('d5ea89b8-949c-47f9-8a01-b827c5639af4', 'P1000009', '51');
INSERT INTO project_material VALUES('d5ea89b8-949c-47f9-8a01-b827c5639af5', 'P1000009', '52');
INSERT INTO project_material VALUES('d5ea89b8-949c-47f9-8a01-b827c5639af6', 'P1000009', '53');
INSERT INTO project_material VALUES('d5ea89b8-949c-47f9-8a01-b827c5639af7', 'P1000010', '54');
INSERT INTO project_material VALUES('d5ea89b8-949c-47f9-8a01-b827c5639af8', 'P1000010', '55');
INSERT INTO project_material VALUES('d5ea89b8-949c-47f9-8a01-b827c5639af9', 'P1000010', '56');
INSERT INTO project_material VALUES('d5ea89b8-949c-47f9-8a01-b827c5639a10', 'P1000010', '57');
INSERT INTO project_material VALUES('d5ea89b8-949c-47f9-8a01-b827c5639a11', 'P1000010', '58');
INSERT INTO project_material VALUES('d5ea89b8-949c-47f9-8a01-b827c5639a12', 'P1000010', '59');
INSERT INTO project_material VALUES('d5ea89b8-949c-47f9-8a01-b827c5639a13', 'P1000010', '60');