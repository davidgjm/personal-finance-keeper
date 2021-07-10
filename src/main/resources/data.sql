-- Industries

-- Top Level Industries
INSERT INTO industry (publisher, code, name) VALUES ('CSRC', 'A', '农、林、牧、渔业');
INSERT INTO industry (publisher, code, name) VALUES ('CSRC', 'B', '采矿业');
INSERT INTO industry (publisher, code, name) VALUES ('CSRC', 'C', '制造业');
INSERT INTO industry (publisher, code, name) VALUES ('CSRC', 'D', '电力、热力、燃气及水生产和供应业');
INSERT INTO industry (publisher, code, name) VALUES ('CSRC', 'E', '建筑业');
INSERT INTO industry (publisher, code, name) VALUES ('CSRC', 'F', '批发和零售业');
INSERT INTO industry (publisher, code, name) VALUES ('CSRC', 'G', '交通运输、仓储和邮政业');
INSERT INTO industry (publisher, code, name) VALUES ('CSRC', 'H', '住宿和餐饮业');
INSERT INTO industry (publisher, code, name) VALUES ('CSRC', 'I', '信息传输、软件和信息技术服务业');
INSERT INTO industry (publisher, code, name) VALUES ('CSRC', 'J', '金融业');
INSERT INTO industry (publisher, code, name) VALUES ('CSRC', 'K', '房地产业');
INSERT INTO industry (publisher, code, name) VALUES ('CSRC', 'L', '租赁和商务服务业');
INSERT INTO industry (publisher, code, name) VALUES ('CSRC', 'M', '科学研究和技术服务业');
INSERT INTO industry (publisher, code, name) VALUES ('CSRC', 'N', '水利、环境和公共设施管理业');
INSERT INTO industry (publisher, code, name) VALUES ('CSRC', 'O', '居民服务、修理和其他服务业');
INSERT INTO industry (publisher, code, name) VALUES ('CSRC', 'P', '教育');
INSERT INTO industry (publisher, code, name) VALUES ('CSRC', 'Q', '卫生和社会工作');
INSERT INTO industry (publisher, code, name) VALUES ('CSRC', 'R', '文化、体育和娱乐业');
INSERT INTO industry (publisher, code, name) VALUES ('CSRC', 'S', '综合');

-----------------------
-- Second level industries
-- A 农、林、牧、渔业
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '01', '农业', 1);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '02', '林业', 1);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '03', '畜牧业', 1);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '04', '渔业', 1);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '05', '农、林、牧、渔服务业', 1);
-- B 采矿业
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '06', '煤炭开采和洗选业', 2);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '07', '石油和天然气开采业', 2);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '08', '黑色金属矿采选业', 2);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '09', '有色金属矿采选业', 2);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '10', '非金属矿采选业', 2);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '11', '开采辅助活动', 2);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '12', '其他采矿业', 2);
-- C 制造业
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '13', '农副食品加工业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '14', '食品制造业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '15', '酒、饮料和精制茶制造业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '16', '烟草制品业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '17', '纺织业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '18', '纺织服装、服饰业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '19', '皮革、毛皮、羽毛及其制品和制鞋业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '20', '木材加工和木、竹、藤、棕、草制品业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '21', '家具制造业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '22', '造纸和纸制品业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '23', '印刷和记录媒介复制业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '24', '文教、工美、体育和娱乐用品制造业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '25', '石油加工、炼焦和核燃料加工业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '26', '化学原料和化学制品制造业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '27', '医药制造业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '28', '化学纤维制造业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '29', '橡胶和塑料制品业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '30', '非金属矿物制品业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '31', '黑色金属冶炼和压延加工业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '32', '有色金属冶炼和压延加工业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '33', '金属制品业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '34', '通用设备制造业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '35', '专用设备制造业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '36', '汽车制造业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '37', '铁路、船舶、航空航天和其他运输设备制造业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '38', '电气机械和器材制造业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '39', '计算机、通信和其他电子设备制造业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '40', '仪器仪表制造业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '41', '其他制造业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '42', '废弃资源综合利用业', 3);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '43', '金属制品、机械和设备修理业', 3);
-- D 电力、热力、燃气及水生产和供应业
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '44', '电力、热力生产和供应业', 4);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '45', '燃气生产和供应业', 4);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '46', '水的生产和供应业', 4);
-- E 建筑业
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '47', '房屋建筑业', 5);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '48', '土木工程建筑业', 5);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '49', '建筑安装业', 5);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '50', '建筑装饰和其他建筑业', 5);
-- F 批发和零售业
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '51', '批发业', 6);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '52', '零售业', 6);
-- G 交通运输、仓储和邮政业
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '53', '铁路运输业', 7);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '54', '道路运输业', 7);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '55', '水上运输业', 7);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '56', '航空运输业', 7);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '57', '管道运输业', 7);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '58', '装卸搬运和运输代理业', 7);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '59', '仓储业', 7);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '60', '邮政业', 7);
-- H 住宿和餐饮业
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '61', '住宿业', 8);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '62', '餐饮业', 8);
-- I 信息传输、软件和信息技术服务业
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '63', '电信、广播电视和卫星传输服务', 9);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '64', '互联网和相关服务', 9);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '65', '软件和信息技术服务业', 9);
-- J 金融业
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '66', '货币金融服务', 10);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '67', '资本市场服务', 10);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '68', '保险业', 10);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '69', '其他金融业', 10);
-- K 房地产业
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '70', '房地产业', 11);
-- L 租赁和商务服务业
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '71', '租赁业', 12);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '72', '商务服务业', 12);
-- M 科学研究和技术服务业
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '73', '研究和试验发展', 13);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '74', '专业技术服务业', 13);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '75', '科技推广和应用服务业', 13);
-- N 水利、环境和公共设施管理业
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '76', '水利管理业', 14);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '77', '生态保护和环境治理业', 14);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '78', '公共设施管理业', 14);
-- O 居民服务、修理和其他服务业
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '79', '居民服务业', 15);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '80', '机动车、电子产品和日用产品修理业', 15);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '81', '其他服务业', 15);
-- P 教育
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '82', '教育', 16);
-- Q 卫生和社会工作
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '83', '卫生', 17);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '84', '社会工作', 17);
-- R 文化、体育和娱乐业
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '85', '新闻和出版业', 18);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '86', '广播、电视、电影和影视录音制作业', 18);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '87', '文化艺术业', 18);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '88', '体育', 18);
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '89', '娱乐业', 18);
-- S 综合
INSERT INTO industry (publisher, code, name,parent_id) VALUES ('CSRC', '90', '综合', 19);