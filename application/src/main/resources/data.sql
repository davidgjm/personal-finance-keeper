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

-------------------------------------------------------------------------------
-- Fund Companies
-------------------------------------------------------------------------------
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('国泰基金', '国泰基金管理有限公司', 'MULTINATIONAL', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('南方基金', '南方基金管理股份有限公司', 'DOMESTIC', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('华夏基金', '华夏基金管理有限公司', 'MULTINATIONAL', '北京', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('华安基金', '华安基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('博时基金', '博时基金管理有限公司', 'DOMESTIC', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('鹏华基金', '鹏华基金管理有限公司', 'MULTINATIONAL', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('长盛基金', '长盛基金管理有限公司', 'MULTINATIONAL', '深圳', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('嘉实基金', '嘉实基金管理有限公司', 'MULTINATIONAL', '上海', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('大成基金', '大成基金管理有限公司', 'DOMESTIC', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('富国基金', '富国基金管理有限公司', 'MULTINATIONAL', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('易方达基金', '易方达基金管理有限公司', 'DOMESTIC', '广东', '广州', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('宝盈基金', '宝盈基金管理有限公司', 'DOMESTIC', '深圳', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('融通基金', '融通基金管理有限公司', 'MULTINATIONAL', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('银华基金', '银华基金管理股份有限公司', 'DOMESTIC', '深圳', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('长城基金', '长城基金管理有限公司', 'DOMESTIC', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('银河基金', '银河基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('泰达宏利基金', '泰达宏利基金管理有限公司', 'MULTINATIONAL', '北京', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('国投瑞银基金', '国投瑞银基金管理有限公司', 'MULTINATIONAL', '上海', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('万家基金', '万家基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('金鹰基金', '金鹰基金管理有限公司', 'DOMESTIC', '广东', '广州', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('招商基金', '招商基金管理有限公司', 'DOMESTIC', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('华宝基金', '华宝基金管理有限公司', 'MULTINATIONAL', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('摩根士丹利华鑫基金', '摩根士丹利华鑫基金管理有限公司', 'MULTINATIONAL', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('国联安基金', '国联安基金管理有限公司', 'MULTINATIONAL', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('海富通基金', '海富通基金管理有限公司', 'MULTINATIONAL', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('长信基金', '长信基金管理有限责任公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('泰信基金', '泰信基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('天治基金', '天治基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('景顺长城基金', '景顺长城基金管理有限公司', 'MULTINATIONAL', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('广发基金', '广发基金管理有限公司', 'DOMESTIC', '广东', '广州', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('兴证全球基金', '兴证全球基金管理有限公司', 'MULTINATIONAL', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('诺安基金', '诺安基金管理有限公司', 'DOMESTIC', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('申万菱信基金', '申万菱信基金管理有限公司', 'MULTINATIONAL', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('中海基金', '中海基金管理有限公司', 'MULTINATIONAL', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('光大保德信基金', '光大保德信基金管理有限公司', 'MULTINATIONAL', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('华富基金', '华富基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('上投摩根基金', '上投摩根基金管理有限公司', 'MULTINATIONAL', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('东方基金', '东方基金管理有限责任公司', 'DOMESTIC', '北京', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('中银基金', '中银基金管理有限公司', 'MULTINATIONAL', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('东吴基金', '东吴基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('国海富兰克林基金', '国海富兰克林基金管理有限公司', 'MULTINATIONAL', '南宁', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('天弘基金', '天弘基金管理有限公司', 'DOMESTIC', '天津', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('华泰柏瑞基金', '华泰柏瑞基金管理有限公司', 'MULTINATIONAL', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('新华基金', '新华基金管理股份有限公司', 'DOMESTIC', '重庆', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('汇添富基金', '汇添富基金管理股份有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('工银瑞信基金', '工银瑞信基金管理有限公司', 'MULTINATIONAL', '北京', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('交银施罗德基金', '交银施罗德基金管理有限公司', 'MULTINATIONAL', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('中信保诚基金', '中信保诚基金管理有限公司', 'MULTINATIONAL', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('建信基金', '建信基金管理有限责任公司', 'MULTINATIONAL', '北京', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('华商基金', '华商基金管理有限公司', 'DOMESTIC', '北京', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('汇丰晋信基金', '汇丰晋信基金管理有限公司', 'MULTINATIONAL', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('益民基金', '益民基金管理有限公司', 'DOMESTIC', '重庆', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('中邮创业基金', '中邮创业基金管理股份有限公司', 'MULTINATIONAL', '北京', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('信达澳银基金', '信达澳银基金管理有限公司', 'MULTINATIONAL', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('诺德基金', '诺德基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('中欧基金', '中欧基金管理有限公司', 'MULTINATIONAL', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('金元顺安基金', '金元顺安基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('浦银安盛基金', '浦银安盛基金管理有限公司', 'MULTINATIONAL', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('农银汇理基金', '农银汇理基金管理有限公司', 'MULTINATIONAL', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('民生加银基金', '民生加银基金管理有限公司', 'MULTINATIONAL', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('西部利得基金', '西部利得基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('浙商基金', '浙商基金管理有限公司', 'DOMESTIC', '杭州', '杭州', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('平安基金', '平安基金管理有限公司', 'MULTINATIONAL', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('富安达基金', '富安达基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('财通基金', '财通基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('方正富邦基金', '方正富邦基金管理有限公司', 'MULTINATIONAL', '北京', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('长安基金', '长安基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('国金基金', '国金基金管理有限公司', 'DOMESTIC', '北京', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('安信基金', '安信基金管理有限责任公司', 'DOMESTIC', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('德邦基金', '德邦基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('华宸未来基金', '华宸未来基金管理有限公司', 'MULTINATIONAL', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('红塔红土基金', '红塔红土基金管理有限公司', 'DOMESTIC', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('英大基金', '英大基金管理有限公司', 'DOMESTIC', '北京', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('江信基金', '江信基金管理有限公司', 'DOMESTIC', '北京', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('太平基金', '太平基金管理有限公司', 'MULTINATIONAL', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('华润元大基金', '华润元大基金管理有限公司', 'MULTINATIONAL', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('前海开源基金', '前海开源基金管理有限公司', 'DOMESTIC', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('东海基金', '东海基金管理有限责任公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('中加基金', '中加基金管理有限公司', 'MULTINATIONAL', '北京', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('兴业基金', '兴业基金管理有限公司', 'DOMESTIC', '福建', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('中融基金', '中融基金管理有限公司', 'DOMESTIC', '深圳', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('国开泰富基金', '国开泰富基金管理有限责任公司', 'MULTINATIONAL', '北京', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('中信建投基金', '中信建投基金管理有限公司', 'DOMESTIC', '北京', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('上银基金', '上银基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('鑫元基金', '鑫元基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('永赢基金', '永赢基金管理有限公司', 'MULTINATIONAL', '浙江', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('兴银基金', '兴银基金管理有限责任公司', 'DOMESTIC', '福建', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('国寿安保基金', '国寿安保基金管理有限公司', 'MULTINATIONAL', '上海', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('圆信永丰基金', '圆信永丰基金管理有限公司', 'MULTINATIONAL', '福建', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('中金基金', '中金基金管理有限公司', 'DOMESTIC', '北京', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('北信瑞丰基金', '北信瑞丰基金管理有限公司', 'DOMESTIC', '北京', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('红土创新基金', '红土创新基金管理有限公司', 'DOMESTIC', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('嘉合基金', '嘉合基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('创金合信基金', '创金合信基金管理有限公司', 'DOMESTIC', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('九泰基金', '九泰基金管理有限公司', 'DOMESTIC', '北京', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('泓德基金', '泓德基金管理有限公司', 'DOMESTIC', '西藏', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('金信基金', '金信基金管理有限公司', 'DOMESTIC', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('新疆前海联合基金', '新疆前海联合基金管理有限公司', 'DOMESTIC', '新疆', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('新沃基金', '新沃基金管理有限公司', 'DOMESTIC', '上海', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('中科沃土基金', '中科沃土基金管理有限公司', 'DOMESTIC', '珠海', '广州', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('富荣基金', '富荣基金管理有限公司', 'DOMESTIC', '广州', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('汇安基金', '汇安基金管理有限责任公司', 'DOMESTIC', '上海', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('先锋基金', '先锋基金管理有限公司', 'DOMESTIC', '深圳', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('中航基金', '中航基金管理有限公司', 'DOMESTIC', '北京', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('华泰保兴基金', '华泰保兴基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('鹏扬基金', '鹏扬基金管理有限公司', 'DOMESTIC', '上海', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('恒生前海基金', '恒生前海基金管理有限公司', 'MULTINATIONAL', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('格林基金', '格林基金管理有限公司', 'DOMESTIC', '北京', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('南华基金', '南华基金管理有限公司', 'DOMESTIC', '浙江', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('凯石基金', '凯石基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('国融基金', '国融基金管理有限公司', 'DOMESTIC', '上海', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('东方阿尔法基金', '东方阿尔法基金管理有限公司', 'DOMESTIC', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('恒越基金', '恒越基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('弘毅远方基金', '弘毅远方基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('合煦智远基金', '合煦智远基金管理有限公司', 'DOMESTIC', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('博道基金', '博道基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('蜂巢基金', '蜂巢基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('中庚基金', '中庚基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('湘财基金', '湘财基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('睿远基金', '睿远基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('朱雀基金', '朱雀基金管理有限公司', 'DOMESTIC', '陕西', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('淳厚基金', '淳厚基金管理有限公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('同泰基金', '同泰基金管理有限公司', 'DOMESTIC', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('惠升基金', '惠升基金管理有限责任公司', 'DOMESTIC', '西藏', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('西藏东财基金', '西藏东财基金管理有限公司', 'DOMESTIC', '西藏', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('博远基金', '博远基金管理有限公司', 'DOMESTIC', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('华融基金', '华融基金管理有限公司', 'DOMESTIC', '河北', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('明亚基金', '明亚基金管理有限责任公司', 'DOMESTIC', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('达诚基金', '达诚基金管理有限责任公司', 'DOMESTIC', '上海', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('兴华基金', '兴华基金管理有限公司', 'DOMESTIC', '青岛', '青岛', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('东兴基金', '东兴基金管理有限公司', 'DOMESTIC', '北京', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('瑞达基金', '瑞达基金管理有限公司', 'DOMESTIC', '厦门', '上海', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('汇泉基金', '汇泉基金管理有限公司', 'DOMESTIC', '北京', '北京', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('百嘉基金', '百嘉基金管理有限公司', 'DOMESTIC', '广东', '广州', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO fund_company(name, full_name, venture_type, registered_location, office_location, created, last_updated) VALUES ('尚正基金', '尚正基金管理有限公司', 'DOMESTIC', '深圳', '深圳', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

