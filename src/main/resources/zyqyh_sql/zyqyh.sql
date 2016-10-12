/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : zyqyh

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2016-10-12 16:46:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attachment
-- ----------------------------
DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment` (
  `id` varchar(36) NOT NULL,
  `uri` varchar(100) NOT NULL,
  `fileName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attachment
-- ----------------------------
INSERT INTO `attachment` VALUES ('0270793b-9b9c-4525-a1bb-6bd2290ac79f', 'ddgl/2016-09-26/5beb2d43-b72d-46da-89ee-d71db5a3623d', null);
INSERT INTO `attachment` VALUES ('0932d5b7-9b0d-4e1b-b258-db490f3f74de', 'ddgl/2016-09-26/43dd14bd-6227-4f77-9817-e3137bb97999', null);
INSERT INTO `attachment` VALUES ('0c88964d-d0d1-4688-9b3b-498f9cde2a8b', 'ddgl/2016-09-26/424270f3-c446-45f3-aa82-ed1ee5cae993', null);
INSERT INTO `attachment` VALUES ('0f73cffd-dd0b-4b23-a501-83bc8b624927', 'ddgl/2016-10-12/ca7b97cc-38ed-428d-af9e-bcfab405e20b', null);
INSERT INTO `attachment` VALUES ('1', 'template', 'userImport.xls');
INSERT INTO `attachment` VALUES ('358c4fb7-2cf8-432f-b5ff-f1f2a7653a66', 'ddgl/2016-09-27/ca7b97cc-38ed-428d-af9e-bcfab405e20b', null);
INSERT INTO `attachment` VALUES ('38998a51-e8d7-4cbe-b841-bcd760cd8af1', 'ddgl/2016-09-26/96cafc48-7df9-4185-bed5-560a46e2ee16', null);
INSERT INTO `attachment` VALUES ('40c96a50-5dab-4567-92bf-e37bbb3cf711', 'ddgl/2016-09-26/d6a9fc0c-a44d-40a9-aaaf-00ff89174ed9', null);
INSERT INTO `attachment` VALUES ('423692d3-71cc-48b5-b300-081e2393c6a6', 'ddgl/2016-10-02/7266deb7-dd4f-4d8d-b33f-4ce08cf0af69', null);
INSERT INTO `attachment` VALUES ('43c747f9-b455-481d-b701-26293987431b', 'ddgl/2016-09-26/cabf887e-3f4e-4696-80d6-e538ea7df398', null);
INSERT INTO `attachment` VALUES ('47c9c7b4-fee9-4c74-a32a-93ac0e0e3831', 'ddgl/2016-09-07', null);
INSERT INTO `attachment` VALUES ('4b8413c0-6641-4513-a9e3-25c56ac04037', 'ddgl/2016-10-02/7266deb7-dd4f-4d8d-b33f-4ce08cf0af69', null);
INSERT INTO `attachment` VALUES ('6a0279c8-3679-441a-a54b-4510d91d9154', 'ddgl/2016-09-07', null);
INSERT INTO `attachment` VALUES ('6cfe394c-727d-42c9-b9d4-815f9c28135a', 'ddgl/2016-09-07', null);
INSERT INTO `attachment` VALUES ('6d87951d-e698-413d-b8d7-80528ab094f0', 'ddgl/2016-09-26/303a0e46-9114-4164-bd38-081f5b9a7ad5', null);
INSERT INTO `attachment` VALUES ('793bfc14-8f82-44da-ab47-42df64d6906e', 'ddgl/2016-09-27/5b731183-d19c-4aa6-a54e-f69ff52d579b', null);
INSERT INTO `attachment` VALUES ('7c51a133-b2ab-4e3a-a28a-db32188e7319', 'ddgl/2016-09-27/7266deb7-dd4f-4d8d-b33f-4ce08cf0af69', null);
INSERT INTO `attachment` VALUES ('802548b7-e5b6-4e60-ae7a-555a914f433d', 'ddgl/2016-09-27/424270f3-c446-45f3-aa82-ed1ee5cae993', null);
INSERT INTO `attachment` VALUES ('8743ca51-b518-425b-9b74-85415ac7d37a', 'project/2016-10-12/66367c8d-3834-4695-92b9-bceee9992187', null);
INSERT INTO `attachment` VALUES ('8b8ce6de-80bb-4439-afb3-8f9da6021d92', 'ddgl/2016-09-27/7266deb7-dd4f-4d8d-b33f-4ce08cf0af69', null);
INSERT INTO `attachment` VALUES ('9e5db5fd-da0e-48f3-b863-fab56830df8e', 'ddgl/2016-09-26/4f1f4c29-7bde-48ec-9d17-d5860e852ea2', null);
INSERT INTO `attachment` VALUES ('ad4d2501-1038-40c9-9437-6111ad630ffb', 'ddgl/2016-10-02/7266deb7-dd4f-4d8d-b33f-4ce08cf0af69', null);
INSERT INTO `attachment` VALUES ('ad8a0be9-42e7-4337-b421-2ec9f8abd545', 'ddgl/2016-09-27/424270f3-c446-45f3-aa82-ed1ee5cae993', null);
INSERT INTO `attachment` VALUES ('aefda677-7da7-484d-b222-6456e5146509', 'ddgl/2016-09-07/3cfa56a7-67a5-4db8-b051-9a6783a88909', null);
INSERT INTO `attachment` VALUES ('b90df086-7587-4c4a-a2c7-49d44bffdf98', 'ddgl/2016-09-27/7266deb7-dd4f-4d8d-b33f-4ce08cf0af69', null);
INSERT INTO `attachment` VALUES ('c76f3645-40b0-45b1-b661-e88aca532517', 'ddgl/2016-09-27/d8fb770c-1407-498f-8516-bb2d8b0f5920', null);
INSERT INTO `attachment` VALUES ('ca4e94fc-97d9-4711-8d13-560f30812ca8', 'ddgl/2016-10-02/7266deb7-dd4f-4d8d-b33f-4ce08cf0af69', null);
INSERT INTO `attachment` VALUES ('cedadada-9372-4d74-9d8e-2ab50dbb9405', 'ddgl/2016-09-26/3f5cef2d-9ea1-4bb3-8b36-6729f5d17aa9', null);
INSERT INTO `attachment` VALUES ('d254030d-4f5a-491c-b01c-ea8a905a54b2', 'ddgl/2016-09-27/7266deb7-dd4f-4d8d-b33f-4ce08cf0af69', null);
INSERT INTO `attachment` VALUES ('d49b0511-5453-4e9b-9399-713fa2b7a977', 'ddgl/2016-09-07', null);
INSERT INTO `attachment` VALUES ('dc241375-a0e1-4995-91f7-03293dd2b55b', 'ddgl/2016-09-27/7266deb7-dd4f-4d8d-b33f-4ce08cf0af69', null);
INSERT INTO `attachment` VALUES ('eb0560f4-35e5-40ba-9683-4e6ffe1cf51a', 'ddgl/2016-10-02/7266deb7-dd4f-4d8d-b33f-4ce08cf0af69', null);
INSERT INTO `attachment` VALUES ('f12a55c0-5981-4505-b490-61e1cd184685', 'ddgl/2016-09-26/86d76d23-06c3-4f8c-b661-db2df6a109b9', null);

-- ----------------------------
-- Table structure for cllqgl
-- ----------------------------
DROP TABLE IF EXISTS `cllqgl`;
CREATE TABLE `cllqgl` (
  `id` varchar(255) NOT NULL DEFAULT '' COMMENT '领取号',
  `lqclh` varchar(255) NOT NULL DEFAULT '' COMMENT '领取材料号',
  `lqtime` varchar(20) DEFAULT '' COMMENT '领取时间',
  `lqsl` decimal(10,2) DEFAULT '0.00' COMMENT '领取数量',
  `sysl` decimal(10,2) DEFAULT '0.00' COMMENT '使用数量',
  `lqdw` varchar(255) NOT NULL DEFAULT '' COMMENT '领取队伍',
  PRIMARY KEY (`id`),
  KEY `lqclh` (`lqclh`),
  KEY `lqdw` (`lqdw`),
  CONSTRAINT `lqclh` FOREIGN KEY (`lqclh`) REFERENCES `clxx` (`id`),
  CONSTRAINT `lqdw` FOREIGN KEY (`lqdw`) REFERENCES `sgdxx` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cllqgl
-- ----------------------------
INSERT INTO `cllqgl` VALUES ('1', '1', '2016-09-07', '21.22', '21.22', 'fc367d75-8df5-4888-8f03-38f8348695ef');

-- ----------------------------
-- Table structure for clxx
-- ----------------------------
DROP TABLE IF EXISTS `clxx`;
CREATE TABLE `clxx` (
  `id` varchar(255) NOT NULL DEFAULT '' COMMENT '材料号',
  `clmc` varchar(100) NOT NULL DEFAULT '' COMMENT '材料名称',
  `cltype` varchar(2) NOT NULL DEFAULT '0' COMMENT '材料类型',
  `detail` varchar(255) DEFAULT NULL COMMENT '材料描述',
  `clgly` varchar(255) NOT NULL COMMENT '材料管理员',
  `clsy` decimal(10,2) DEFAULT '0.00' COMMENT '材料总剩余',
  PRIMARY KEY (`id`),
  KEY `clgly` (`clgly`),
  CONSTRAINT `clgly` FOREIGN KEY (`clgly`) REFERENCES `p_user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clxx
-- ----------------------------
INSERT INTO `clxx` VALUES ('1', '材料1', '01', '材料详细1', '1', '10000.00');
INSERT INTO `clxx` VALUES ('2', '材料2', '02', '材料详细2', '2', '20000.00');
INSERT INTO `clxx` VALUES ('3', '材料3', '03', '材料详细3', '3', '30000.00');

-- ----------------------------
-- Table structure for gzzd
-- ----------------------------
DROP TABLE IF EXISTS `gzzd`;
CREATE TABLE `gzzd` (
  `id` varchar(50) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `attachmentId` varchar(50) DEFAULT NULL,
  `lastModifyUserId` varchar(50) DEFAULT NULL,
  `lastModifyTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gzzd
-- ----------------------------

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` varchar(36) NOT NULL,
  `fromUser` varchar(36) DEFAULT NULL,
  `toSgdId` varchar(36) DEFAULT NULL,
  `type` varchar(15) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `attachmentId` varchar(36) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('0350e82a-5fa8-47dd-8a53-c099caafdaa1', 'admin', '1', null, '2016-08-31 15:41:24', null, 'xclx.do');
INSERT INTO `message` VALUES ('03f3ce4b-5fee-4773-b36b-74e7d1586a40', 'admin', '1', null, '2016-08-31 15:41:25', null, '');
INSERT INTO `message` VALUES ('090c7c31-a607-4145-8e67-1c450e497c70', 'admin', '1', null, '2016-08-31 15:41:24', null, 'xclx.do');
INSERT INTO `message` VALUES ('0a774c41-40f7-43db-84cc-ec369c8f5634', 'admin', 'fc367d75-8df5-4888-8f03-38f8348695ef', null, '2016-10-12 16:34:00', null, '&nbsp;sdfsdf');
INSERT INTO `message` VALUES ('0ba2f311-70f3-439c-a856-d8fb5559e7ac', 'admin', '1', null, '2016-08-31 15:40:55', null, '&nbsp;nihao<img class=\"qqface qqface9\" title=\"大哭\" src=\"static/css/images/spacer.gif\"><img class=\"qqface qqface7\" title=\"闭嘴\" src=\"static/css/images/spacer.gif\">');
INSERT INTO `message` VALUES ('0cc3af6c-97c0-4a6d-b4a8-15d73402cfe5', 'admin', '1', null, '2016-08-31 15:41:18', null, '');
INSERT INTO `message` VALUES ('11099590-8cc3-4b21-b440-5734607a6ded', 'admin', '1', null, '2016-08-29 13:38:16', null, '&nbsp;あｓｄｆ');
INSERT INTO `message` VALUES ('11dbd0a7-38b3-4e4a-9c09-486fd8f9cadf', 'admin', 'fc367d75-8df5-4888-8f03-38f8348695ef', null, '2016-09-05 18:09:44', null, '&nbsp;111');
INSERT INTO `message` VALUES ('1a08c3c0-0662-42ec-9501-f9e415c43cff', 'admin', 'fc367d75-8df5-4888-8f03-38f8348695ef', null, '2016-09-05 18:33:13', null, '&nbsp;sadfasdf<br>');
INSERT INTO `message` VALUES ('2e66b0ac-4fdb-47fa-8323-64e89b7d0ed5', 'admin', '1', null, '2016-08-29 17:19:46', null, '&nbsp;１１２２１１');
INSERT INTO `message` VALUES ('2ef31c31-2eca-4f45-984b-597553722565', 'admin', '1', null, '2016-08-31 15:40:46', null, '&nbsp;nihao<img class=\"qqface qqface9\" title=\"大哭\" src=\"static/css/images/spacer.gif\"><img class=\"qqface qqface7\" title=\"闭嘴\" src=\"static/css/images/spacer.gif\">');
INSERT INTO `message` VALUES ('334a7ef3-b120-4a4f-bf3c-09bc243a7322', 'admin', '1', null, '2016-08-29 17:21:04', null, '&nbsp;２３２３');
INSERT INTO `message` VALUES ('357c46ab-df4e-48ca-b807-9d4237fc3b8c', 'admin', '1', null, '2016-08-29 11:59:17', null, '&nbsp;１２３');
INSERT INTO `message` VALUES ('51a6d7f5-bb0e-42d0-af7f-982dc2c05d31', 'admin', '1', null, '2016-08-31 15:40:48', null, '&nbsp;nihao<img class=\"qqface qqface9\" title=\"大哭\" src=\"static/css/images/spacer.gif\"><img class=\"qqface qqface7\" title=\"闭嘴\" src=\"static/css/images/spacer.gif\">');
INSERT INTO `message` VALUES ('62a0e479-780b-4592-aec1-931c1ecd24c1', 'admin', '1', null, '2016-08-29 13:44:17', null, '&nbsp;21');
INSERT INTO `message` VALUES ('635fa914-34d0-42d3-a22a-e77e7f50f5e7', 'admin', null, null, '2016-08-30 19:10:12', null, '&nbsp;asdfasdf');
INSERT INTO `message` VALUES ('65167cc5-0d4d-4a0d-ac4e-7c129d554b41', 'admin', '1', null, '2016-08-31 15:40:47', null, '&nbsp;nihao<img class=\"qqface qqface9\" title=\"大哭\" src=\"static/css/images/spacer.gif\"><img class=\"qqface qqface7\" title=\"闭嘴\" src=\"static/css/images/spacer.gif\">');
INSERT INTO `message` VALUES ('66eaa3e7-aec0-4ae0-8a18-9e6a3940f959', 'admin', '1', null, '2016-08-29 13:35:02', null, '&nbsp;ｓｄｆ');
INSERT INTO `message` VALUES ('67c945ba-5417-4c15-bca7-3b03a925629e', 'admin', 'fc367d75-8df5-4888-8f03-38f8348695ef', null, '2016-09-05 18:33:20', null, 'asdfasdfsdfwe');
INSERT INTO `message` VALUES ('7107c105-4c42-49d9-a02a-c0f92840d877', 'admin', '1', null, '2016-08-29 11:57:07', null, '&nbsp;1212');
INSERT INTO `message` VALUES ('7355a4b9-ed06-4bea-ab31-25f771c011ca', 'admin', '1', null, '2016-08-31 15:41:18', null, 'xclx.do');
INSERT INTO `message` VALUES ('7fd28176-1c24-424a-ab49-3c992c239ec1', 'admin', '1', null, '2016-08-29 12:00:30', null, '&nbsp;１２３');
INSERT INTO `message` VALUES ('842011bb-4224-43bc-87da-bbf65776cde7', 'admin', '1', null, '2016-08-31 15:40:47', null, '&nbsp;nihao<img class=\"qqface qqface9\" title=\"大哭\" src=\"static/css/images/spacer.gif\"><img class=\"qqface qqface7\" title=\"闭嘴\" src=\"static/css/images/spacer.gif\">');
INSERT INTO `message` VALUES ('8d55cf8e-5650-4db4-9006-ce3f6c5c3274', 'admin', '1', null, '2016-08-29 12:00:35', null, '&nbsp;１２３');
INSERT INTO `message` VALUES ('8f45ffa8-0f93-424b-af53-7c7b3614c266', 'admin', 'fc367d75-8df5-4888-8f03-38f8348695ef', null, '2016-09-05 18:09:08', null, '&nbsp;asdfasdf');
INSERT INTO `message` VALUES ('94de8bc6-bbb4-486c-a294-81af96f2e2a9', 'admin', '1', null, '2016-08-31 15:40:55', null, '&nbsp;nihao<img class=\"qqface qqface9\" title=\"大哭\" src=\"static/css/images/spacer.gif\"><img class=\"qqface qqface7\" title=\"闭嘴\" src=\"static/css/images/spacer.gif\">');
INSERT INTO `message` VALUES ('97c14eb7-591a-4388-881c-deba3cdf174f', 'admin', '1', null, '2016-08-29 11:52:31', null, '&nbsp;1212');
INSERT INTO `message` VALUES ('9d344a5f-e18c-466e-b7ce-72ec7a1fc77b', 'admin', '1', null, '2016-08-29 11:57:37', null, '&nbsp;1212');
INSERT INTO `message` VALUES ('9d3a00d6-dd07-46e0-b755-4523e6095381', 'admin', '1', null, '2016-08-29 13:38:07', null, '&nbsp;あｓｄｆ');
INSERT INTO `message` VALUES ('9f1c889e-c964-4ed6-b072-831899785168', 'admin', '', null, '2016-09-05 17:52:47', null, '&nbsp;123123');
INSERT INTO `message` VALUES ('9f4e1752-3cdb-4ecc-ab1d-7aaacbfddef0', 'admin', 'fc367d75-8df5-4888-8f03-38f8348695ef', null, '2016-08-30 19:18:31', null, '&nbsp;sss');
INSERT INTO `message` VALUES ('ad99c398-b8e9-4621-9ae8-480af854bbd9', 'admin', '1', null, '2016-08-29 11:51:53', null, '&nbsp;1212');
INSERT INTO `message` VALUES ('ae38f976-40d9-48cb-8b6f-e7c198082e7c', 'admin', 'fc367d75-8df5-4888-8f03-38f8348695ef', null, '2016-08-30 19:17:35', null, '&nbsp;sdf');
INSERT INTO `message` VALUES ('ae47671a-f878-4433-9f9f-3647eb3bf8bd', 'admin', '1', null, null, null, '&nbsp;12');
INSERT INTO `message` VALUES ('ae8e68d1-30cb-4a7c-9cda-119ccfe4ffb7', 'admin', '', null, '2016-09-05 17:52:54', null, 'sdfsfdsadfa');
INSERT INTO `message` VALUES ('ae8f5e08-c78f-4186-9197-8ad1a8718cf9', 'admin', '1', null, '2016-08-31 15:40:55', null, '&nbsp;nihao<img class=\"qqface qqface9\" title=\"大哭\" src=\"static/css/images/spacer.gif\"><img class=\"qqface qqface7\" title=\"闭嘴\" src=\"static/css/images/spacer.gif\">');
INSERT INTO `message` VALUES ('b44abc6a-cfd0-488e-8c04-adfca32b0f07', 'admin', '1', null, '2016-08-31 15:41:18', null, 'xclx.do');
INSERT INTO `message` VALUES ('ba294086-1390-4bb8-bc7b-466f23576d05', 'admin', '', null, '2016-09-05 17:45:26', null, '123123');
INSERT INTO `message` VALUES ('bd2db626-c76d-41de-abce-1083436c4510', 'admin', '1', null, '2016-08-29 11:52:18', null, '&nbsp;1212');
INSERT INTO `message` VALUES ('c1020333-3fe2-491b-8750-d4a08870fd5d', 'admin', '1', null, '2016-08-29 13:43:27', null, '&nbsp;あｓｄｆ');
INSERT INTO `message` VALUES ('c56ef56d-105c-4dee-b29c-df48ebad442a', 'admin', '1', null, '2016-08-29 17:19:14', null, '&nbsp;１２１２３１２３１２３１２３１２３');
INSERT INTO `message` VALUES ('c6e5faef-25c4-4393-b9db-a2dc802c0d5b', 'admin', '1', null, '2016-08-31 15:40:55', null, '&nbsp;nihao<img class=\"qqface qqface9\" title=\"大哭\" src=\"static/css/images/spacer.gif\"><img class=\"qqface qqface7\" title=\"闭嘴\" src=\"static/css/images/spacer.gif\">');
INSERT INTO `message` VALUES ('c6ea7403-1906-45ca-b4fc-2f1c5c24bed1', 'admin', '', null, '2016-08-30 19:21:20', null, '&nbsp;232323');
INSERT INTO `message` VALUES ('ce156dd2-5487-4e06-8d07-8f22cd925e36', 'admin', '1', null, '2016-08-29 12:00:11', null, '&nbsp;１２３');
INSERT INTO `message` VALUES ('d62d11a7-1f41-44a9-aa53-315613debad6', 'admin', '', null, '2016-09-05 17:45:17', null, '&nbsp;123123');
INSERT INTO `message` VALUES ('dbb46d04-3756-4404-a0bf-e7314500c630', 'admin', '1', null, '2016-08-31 15:41:12', null, 'xclx.do');
INSERT INTO `message` VALUES ('e383283f-b809-497e-87f3-9f432dbcd268', 'admin', '', null, '2016-09-05 17:52:50', null, '1231wrwer');
INSERT INTO `message` VALUES ('ebb829d8-37f5-4917-8647-48931c6b1a58', 'admin', '1', null, '2016-08-31 15:41:17', null, 'xclx.do');
INSERT INTO `message` VALUES ('ee294301-faac-4efa-b4db-072ae655891f', 'admin', '1', null, '2016-08-31 15:41:25', null, '');
INSERT INTO `message` VALUES ('fa6a67d0-62a7-4c78-bac2-99e8656ecbde', 'admin', '1', null, '2016-08-31 15:40:48', null, '&nbsp;nihao<img class=\"qqface qqface9\" title=\"大哭\" src=\"static/css/images/spacer.gif\"><img class=\"qqface qqface7\" title=\"闭嘴\" src=\"static/css/images/spacer.gif\">');

-- ----------------------------
-- Table structure for order_project
-- ----------------------------
DROP TABLE IF EXISTS `order_project`;
CREATE TABLE `order_project` (
  `project_id` varchar(50) NOT NULL,
  `order_id` varchar(50) NOT NULL,
  PRIMARY KEY (`project_id`,`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_project
-- ----------------------------
INSERT INTO `order_project` VALUES ('66367c8d-3834-4695-92b9-bceee9992187', 'ca7b97cc-38ed-428d-af9e-bcfab405e20b');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `PER_ID` varchar(36) NOT NULL,
  `PER_NAME` varchar(50) DEFAULT NULL,
  `PARENT_PER_ID` varchar(36) DEFAULT NULL,
  `PER_URL` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`PER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '系统管理', '', '');
INSERT INTO `permission` VALUES ('10', '现场相关管理', null, null);
INSERT INTO `permission` VALUES ('11', '现场管理', '10', 'xcglManage/xcglManage.do');
INSERT INTO `permission` VALUES ('12', '现场检查', '10', 'xcglManage/xcjcManage.do');
INSERT INTO `permission` VALUES ('13', '项目管理', null, null);
INSERT INTO `permission` VALUES ('14', '工程承揽情况', '13', 'projectManage/projectManage.do');
INSERT INTO `permission` VALUES ('15', 'order:edit', null, '');
INSERT INTO `permission` VALUES ('16', 'sgd:edit', null, null);
INSERT INTO `permission` VALUES ('17', 'gzzd:edit', null, null);
INSERT INTO `permission` VALUES ('18', 'project:edit', null, null);
INSERT INTO `permission` VALUES ('19', 'xcgl:edit', null, null);
INSERT INTO `permission` VALUES ('2', '菜单管理', '2', 'system/menuManage.do');
INSERT INTO `permission` VALUES ('3', '人员管理', '2', 'system/userManage.do');
INSERT INTO `permission` VALUES ('4', '角色管理', '2', 'system/roleManage.do');
INSERT INTO `permission` VALUES ('5', '基础管理', null, null);
INSERT INTO `permission` VALUES ('6', '订单管理', '5', 'baseManage/orderManage.do');
INSERT INTO `permission` VALUES ('7', '规章制度', '5', 'baseManage/gzzdManage.do');
INSERT INTO `permission` VALUES ('8', '材料管理', '5', 'baseManage/clManage.do');
INSERT INTO `permission` VALUES ('9', '施工队伍', '5', 'baseManage/sgdwManage.do');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `project_id` varchar(50) DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  `attachment_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `project_detail` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('66367c8d-3834-4695-92b9-bceee9992187', '55try', '8743ca51-b518-425b-9b74-85415ac7d37a', '2016-10-12 16:42:31', 'tyutyiytu');

-- ----------------------------
-- Table structure for p_order
-- ----------------------------
DROP TABLE IF EXISTS `p_order`;
CREATE TABLE `p_order` (
  `ORDER_ID` varchar(36) NOT NULL,
  `ORDER_NAME` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '派单日期',
  `UPDATE_DATE` datetime DEFAULT NULL,
  `CREATE_USER` varchar(36) DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL COMMENT '工程内容',
  `SGDID` varchar(36) DEFAULT NULL COMMENT '施工单位',
  `attachment_id` varchar(255) DEFAULT NULL,
  `ORDER_NUMBER` varchar(255) DEFAULT NULL COMMENT '项目编号',
  `LX_NUMBER` varchar(255) DEFAULT NULL COMMENT '工作联系单编号',
  `START_TIME` datetime DEFAULT NULL COMMENT '要求开工日期',
  `END_TIME` datetime DEFAULT NULL COMMENT '要求完工日期',
  `REAL_DETAIL` varchar(255) DEFAULT NULL COMMENT '实际完成情况',
  `PROBLEM` varchar(255) DEFAULT NULL COMMENT '存在问题',
  PRIMARY KEY (`ORDER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_order
-- ----------------------------
INSERT INTO `p_order` VALUES ('424270f3-c446-45f3-aa82-ed1ee5cae993', 'asdfasd', '2016-09-26 14:39:38', '2016-09-27 15:46:06', null, 'dgrtdrg', 'fc367d75-8df5-4888-8f03-38f8348695ef', '802548b7-e5b6-4e60-ae7a-555a914f433d', 'sadfasdf', 'asdfefe', '2016-09-10 00:00:00', '2016-09-16 00:00:00', 'dfgdfgd', '');
INSERT INTO `p_order` VALUES ('5b731183-d19c-4aa6-a54e-f69ff52d579b', '32', '2016-09-27 15:24:24', '2016-09-27 15:24:24', null, '23', '请选择施工队', '793bfc14-8f82-44da-ab47-42df64d6906e', '23', '23', '2016-09-08 00:00:00', '2016-09-15 00:00:00', '234', '234');
INSERT INTO `p_order` VALUES ('7266deb7-dd4f-4d8d-b33f-4ce08cf0af69', '32', '2016-09-27 15:25:14', '2016-10-02 15:59:11', null, '23', 'fc367d75-8df5-4888-8f03-38f8348695ef', 'ca4e94fc-97d9-4711-8d13-560f30812ca8', '23', '23', '2016-09-08 00:00:00', '2016-09-15 00:00:00', '234', '234');
INSERT INTO `p_order` VALUES ('86d76d23-06c3-4f8c-b661-db2df6a109b9', '32', '2016-09-26 14:38:40', '2016-09-26 14:38:40', null, '23', '请选择施工队', 'f12a55c0-5981-4505-b490-61e1cd184685', '23', '23', '2016-09-08 00:00:00', '2016-09-15 00:00:00', '', '');
INSERT INTO `p_order` VALUES ('96cafc48-7df9-4185-bed5-560a46e2ee16', '32', '2016-09-26 14:36:30', '2016-09-26 14:36:30', null, '23', '请选择施工队', '38998a51-e8d7-4cbe-b841-bcd760cd8af1', '23', '23', '2016-09-08 00:00:00', '2016-09-15 00:00:00', '', '');
INSERT INTO `p_order` VALUES ('ca7b97cc-38ed-428d-af9e-bcfab405e20b', 'asdfasd', '2016-09-27 15:09:00', '2016-10-12 16:42:55', null, '', '请选择施工队', '0f73cffd-dd0b-4b23-a501-83bc8b624927', 'sadfasdf', 'asdfefe', '2016-09-22 00:00:00', '2016-09-16 00:00:00', '', '');
INSERT INTO `p_order` VALUES ('d8fb770c-1407-498f-8516-bb2d8b0f5920', '32', '2016-09-27 15:21:11', '2016-09-27 15:21:11', null, '23', 'fc367d75-8df5-4888-8f03-38f8348695ef', 'c76f3645-40b0-45b1-b661-e88aca532517', '23', '23', '2016-09-08 00:00:00', '2016-09-15 00:00:00', '', '');

-- ----------------------------
-- Table structure for p_org
-- ----------------------------
DROP TABLE IF EXISTS `p_org`;
CREATE TABLE `p_org` (
  `ORG_ID` varchar(36) NOT NULL,
  `ORG_NAME` varchar(50) DEFAULT NULL,
  `PARENT_ORG_ID` varchar(36) DEFAULT NULL,
  `ORG_TYPE` int(11) DEFAULT NULL,
  `AUTH_CODE` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `CREATE_USER` varchar(36) DEFAULT NULL,
  `EXT1` varchar(50) DEFAULT NULL,
  `EXT2` varchar(50) DEFAULT NULL,
  `EXT3` varchar(50) DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ORG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_org
-- ----------------------------

-- ----------------------------
-- Table structure for p_user
-- ----------------------------
DROP TABLE IF EXISTS `p_user`;
CREATE TABLE `p_user` (
  `USER_ID` varchar(36) NOT NULL,
  `USER_NAME` varchar(50) DEFAULT NULL,
  `USER_PWD` varchar(50) DEFAULT NULL,
  `IS_GUEST` int(11) DEFAULT NULL,
  `IS_LOCKED` int(11) DEFAULT NULL,
  `ROLE_ID` varchar(36) DEFAULT NULL,
  `ORG_ID` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `CREATE_USER` varchar(36) DEFAULT NULL,
  `openid` varchar(50) DEFAULT NULL,
  `wechatNo` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `id_no` varchar(20) DEFAULT NULL,
  `education` varchar(1) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `major` varchar(30) DEFAULT NULL,
  `gangwei` varchar(30) DEFAULT NULL,
  `yongglx` varchar(30) DEFAULT NULL,
  `gongzsj` int(11) DEFAULT NULL,
  `gongzds` varchar(10) DEFAULT NULL,
  `bendsgzkssj` datetime DEFAULT NULL,
  `zhengsmc` varchar(255) DEFAULT NULL,
  `ziz_no` varchar(255) DEFAULT NULL,
  `ziz_time` datetime DEFAULT NULL,
  `ziz_org` varchar(255) DEFAULT NULL,
  `ziz_endtime` datetime DEFAULT NULL,
  `baox` varchar(255) DEFAULT NULL,
  `other` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  KEY `FK_Reference_1` (`ROLE_ID`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_user
-- ----------------------------
INSERT INTO `p_user` VALUES ('041ed6bc-d689-4128-bfe6-79a690cf96e1', 'wangerxiao', '', null, null, '2', 'fc367d75-8df5-4888-8f03-38f8348695ef', null, null, null, null, 'erxiao@163.com', '王二小', null, '0', null, '', '1', '', '', '1', '1', '1', null, '', null, '1', '', null, '', null, '', '');
INSERT INTO `p_user` VALUES ('1', 'admin', 'admin', null, null, '1', '1', '2016-08-16 20:41:38', '2016-08-16 20:41:40', 'admin', null, 'guanliyuan', '管理员', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `p_user` VALUES ('2', 'zhangsan', '', null, null, '2', 'fc367d75-8df5-4888-8f03-38f8348695ef', null, null, null, null, 'zhangsan', '张三', null, '0', null, '', '1', '', '', '2', '1', '1', null, '', null, '1', '', null, '', null, '', '');
INSERT INTO `p_user` VALUES ('3', 'lisi', '', null, null, '2', 'fc367d75-8df5-4888-8f03-38f8348695ef', null, null, null, null, 'lisi111', '李四', null, '0', '2016-10-11', '234', '1', '23423', '234@asdf.com', '3', '1', '1', '3', '234', '2016-10-11 00:00:00', '1', '234', '2016-10-11 00:00:00', '234', '2016-10-11 00:00:00', '234', '234');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `ROLE_ID` varchar(36) NOT NULL,
  `ROLE_NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员用户');
INSERT INTO `role` VALUES ('2', '普通用户');
INSERT INTO `role` VALUES ('3', '施工队长');

-- ----------------------------
-- Table structure for role_pers
-- ----------------------------
DROP TABLE IF EXISTS `role_pers`;
CREATE TABLE `role_pers` (
  `ROLE_ID` varchar(36) NOT NULL,
  `PER_ID` varchar(36) NOT NULL,
  PRIMARY KEY (`ROLE_ID`,`PER_ID`),
  KEY `FK_Reference_9` (`PER_ID`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ROLE_ID`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`PER_ID`) REFERENCES `permission` (`PER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_pers
-- ----------------------------
INSERT INTO `role_pers` VALUES ('1', '1');
INSERT INTO `role_pers` VALUES ('1', '10');
INSERT INTO `role_pers` VALUES ('2', '10');
INSERT INTO `role_pers` VALUES ('3', '10');
INSERT INTO `role_pers` VALUES ('1', '11');
INSERT INTO `role_pers` VALUES ('2', '11');
INSERT INTO `role_pers` VALUES ('3', '11');
INSERT INTO `role_pers` VALUES ('1', '12');
INSERT INTO `role_pers` VALUES ('2', '12');
INSERT INTO `role_pers` VALUES ('1', '13');
INSERT INTO `role_pers` VALUES ('2', '13');
INSERT INTO `role_pers` VALUES ('3', '13');
INSERT INTO `role_pers` VALUES ('1', '14');
INSERT INTO `role_pers` VALUES ('2', '14');
INSERT INTO `role_pers` VALUES ('3', '14');
INSERT INTO `role_pers` VALUES ('1', '2');
INSERT INTO `role_pers` VALUES ('1', '3');
INSERT INTO `role_pers` VALUES ('1', '4');
INSERT INTO `role_pers` VALUES ('1', '5');
INSERT INTO `role_pers` VALUES ('2', '5');
INSERT INTO `role_pers` VALUES ('1', '6');
INSERT INTO `role_pers` VALUES ('2', '6');
INSERT INTO `role_pers` VALUES ('1', '7');
INSERT INTO `role_pers` VALUES ('2', '7');
INSERT INTO `role_pers` VALUES ('1', '8');
INSERT INTO `role_pers` VALUES ('2', '8');
INSERT INTO `role_pers` VALUES ('1', '9');
INSERT INTO `role_pers` VALUES ('2', '9');

-- ----------------------------
-- Table structure for sgdgps
-- ----------------------------
DROP TABLE IF EXISTS `sgdgps`;
CREATE TABLE `sgdgps` (
  `cph` varchar(10) NOT NULL,
  `gps` varchar(100) DEFAULT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`cph`,`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sgdgps
-- ----------------------------

-- ----------------------------
-- Table structure for sgdxx
-- ----------------------------
DROP TABLE IF EXISTS `sgdxx`;
CREATE TABLE `sgdxx` (
  `id` varchar(36) NOT NULL,
  `sgdmc` varchar(255) DEFAULT NULL,
  `ctype` varchar(255) DEFAULT NULL,
  `detail` varchar(500) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `duizhang` varchar(36) NOT NULL,
  `cph` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `duizhang` (`duizhang`),
  CONSTRAINT `duizhang` FOREIGN KEY (`duizhang`) REFERENCES `p_user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sgdxx
-- ----------------------------
INSERT INTO `sgdxx` VALUES ('fc367d75-8df5-4888-8f03-38f8348695ef', 'SADasd', '323232', 'asd', '234', '2', '123456');
