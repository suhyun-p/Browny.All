insert into club (name) values ('아호라'); -- 1
insert into club (name) values ('아댄스'); -- 2


insert into user (nickname, sex, instructor) values ('브라우니', 'M', false); -- 1
insert into user (nickname, sex, instructor) values ('칼리', 'F', true ); -- 2

insert into user (nickname, sex, instructor, account) values ('스칼렛', 'F', true , '우리은행 180-08-244668 전신영'); -- 3
insert into instructor_contact (instructor_no, type, contact) values (3, 'P', '010-2335-8364');
insert into instructor_contact (instructor_no, type, contact) values (3, 'K', 'ssg8364');
insert into instructor_contact (instructor_no, type, name, contact) values (3, 'NB', '아오라(Ahora)살사&바차타', 'http://band.us/@ahora');
insert into instructor_career (instructor_no, career) values (3, '2006~2017 Salsa Latin Club, Salsa Holic 서울 대표 강사');
insert into instructor_career (instructor_no, career) values (3, '2014 국민대 평생교육원 소셜댄스학부 교양지도교수');
insert into instructor_career (instructor_no, career) values (3, '2009 Korea Salsa Competition 출전');
insert into instructor_career (instructor_no, career) values (3, '2011 Royal Caribbean Salsa Workshop 수료');
insert into instructor_career (instructor_no, career) values (3, '2015 국민대 총장배 살사&바차타대회 우승(바차타 단체)');
insert into instructor_career (instructor_no, career) values (3, '2017 명지대 총장배 국제실용댄스대회 최우수 (살사 커플)');
insert into instructor_career (instructor_no, career) values (3, '2017 삼육대 총장배 댄스경연대회 일반부 대상 (바차타단체)');
insert into instructor_career (instructor_no, career) values (3, '2017 스페인/CADIZ 바차타센슈얼위크 프로과정 수료');
insert into instructor_career (instructor_no, career) values (3, '한국비서협회 기념행사 커플 Salsa 축하공연');
insert into instructor_career (instructor_no, career) values (3, '국제 Rotary Club 송년회 Salsa 축하공연');
insert into instructor_career (instructor_no, career) values (3, '2015 중국상해 Bachata bemucho 한국대표 축하공연');
insert into instructor_career (instructor_no, career) values (3, '2015 Korea Salsa Competition 축하공연');
insert into instructor_career (instructor_no, career) values (3, '2017 대구 Bonita Sensual Bachata 초청 워크샵');
insert into instructor_career (instructor_no, career) values (3, '2017 한중 살사&바차타 카니발 Sensual Bachata 공연');
insert into instructor_career (instructor_no, career) values (3, '2017 싱가포르 라틴엑스트라바간자 한국팀 대표공연');

-- 4
insert into user (nickname, sex, instructor, account) values ('퓨마', 'M', true , 'NH농협 010-7290-9770-19 유무형');
insert into instructor_contact (instructor_no, type, contact) values (4, 'P', '010-7290-9770');
insert into instructor_contact (instructor_no, type, contact) values (4, 'K', 'ruemoo1');
insert into instructor_contact (instructor_no, type, name, contact) values (4, 'NB', '센슈얼 피플', 'http://band.us/@sensualpeople');
insert into instructor_contact (instructor_no, type, name, contact) values (4, 'Y', '라틴댄스TV', 'https://www.youtube.com/channel/UCJHRtPe10RBU5V0wYX1CkPQ');

-- 5
insert into user (nickname, sex, instructor, account) values ('태수', 'M', true , '하나은행 549-910154-52007 박성찬');
insert into instructor_contact (instructor_no, type, contact) values (5, 'P', '010-2736-2117');

-- 6
insert into user (nickname, sex, instructor, account) values ('실버', 'M', true , '하나은행 549-910154-52007 박성찬');
insert into instructor_contact (instructor_no, type, contact) values (6, 'P', '010-4929-8603');
insert into instructor_contact (instructor_no, type, contact) values (6, 'K', 'silver1982');

-- 7
insert into user (nickname, sex, instructor, account) values ('리키쌤', 'M', true , null);

-- 8
insert into user (nickname, sex, instructor, account) values ('에릭', 'M', true , null);

-- 9
insert into user (nickname, sex, instructor, account) values ('미랭', 'F', true , null);

-- 10
insert into user (nickname, sex, instructor, account) values ('로즈', 'F', true , null);
insert into instructor_contact (instructor_no, type, contact) values (10, 'P', '010-4738-5380');

-- 11
insert into user (nickname, sex, instructor, account) values ('이소', 'F', true , null);

-- 12
insert into user (nickname, sex, instructor, account) values ('타미', 'M', true , null);

-- 13
insert into user (nickname, sex, instructor, account) values ('카를로스', 'M', true , null);

-- 14
insert into user (nickname, sex, instructor, account) values ('케르', 'M', true , null);
insert into instructor_contact (instructor_no, type, contact) values (14, 'P', '010-2550-8864');

-- 15
insert into user (nickname, sex, instructor, account) values ('해향', 'F', true , null);
insert into instructor_contact (instructor_no, type, contact) values (15, 'P', '010-7900-2007');

-- 16
insert into user (nickname, sex, instructor, account) values ('이소', 'F', true , '우리은행 110-251-1074916 이소정');
insert into instructor_contact (instructor_no, type, contact) values (16, 'P', '010-9914-1985');

-- 17
insert into user (nickname, sex, instructor, account) values ('짬장', 'M', true , null);

-- 1
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('B', 'HD', 'P', 'F', 3, null, 'Team Ahora Ladies', '2018-10-13', '2018-11-24', '총 6주, 매주 토요일', '19:30', '21:00', '텐션', 0, 120000, '우리은행 180-08-244668 전신영', 'class_1.jpg');
insert into class_contact (class_no, instructor_no, type, contact) values (1, 3, 'P', '010-2335-8364');
-- insert into class_contact (class_no, instructor_no, type, contact) values (1, 3, 'K', 'ssg8364');
insert into class_date_option (class_no, opt) values (1, '해외 워크샵 휴강(10.27)');
insert into class_price_option (class_no, opt) values (1, '기수강자, 2인 이상 신청 시 2만원 할인');
insert into class_price_option (class_no, opt) values (1, '중복할인 불가');
-- insert into class_earlybird (class_no, deadline, amount) values (1, '2019-03-15', 5000);
-- insert into class_earlybird (class_no, deadline, amount) values (1, '2019-04-10', 10000);

-- 2
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('B', 'HD', 'T', null, 4, 3, 'AHORA 바차타 트레이닝', '2018-10-30', '2018-11-27', '총 5주, 매주 화요일', '20:00', '21:00', '텐션', 70000, 50000, 'NH농협 010-7290-9770-19 유무형', 'class_2.jpg');
insert into class_contact (class_no, instructor_no, type, contact) values (2, 4, 'P', '010-7290-9770');
insert into class_price_option (class_no, opt) values (2, '기수강자, 수강자 소개 및 2인 이상 등록 시 1만원 할인');

-- 3
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('B', 'HD', 'C', null, 4, null, '[센슈얼 바차타] 중급 딥 패턴 클리닉', '2018-11-07', '2018-12-05', '총 5주, 매주 수요일', '20:00', '21:00', '홍대스튜디오(추후공지)', 60000, 40000, 'NH농협 010-7290-9770-19 유무형', 'class_3.jpg');
insert into class_contact (class_no, instructor_no, type, contact) values (3, 4, 'P', '010-7290-9770');
insert into class_contact (class_no, instructor_no, type, contact) values (3, 4, 'K', 'ruemoo1');
insert into class_price_option (class_no, opt) values (3, '커플 신청 시 각 1만원 할인');
insert into class_price_option (class_no, opt) values (3, '재수강자 1만원 할인');
insert into class_price_option (class_no, opt) values (3, '중복할인 불가');

-- 4
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('B', 'HD', 'C', null, 4, null, '[센슈얼 바차타] 중급 딥 패턴 클리닉', '2018-11-09', '2018-12-07', '총 5주, 매주 금요일', '20:00', '21:00', '홍대스튜디오(추후공지)', 60000, 40000, 'NH농협 010-7290-9770-19 유무형', 'class_3.jpg');
insert into class_contact (class_no, instructor_no, type, contact) values (4, 4, 'P', '010-7290-9770');
insert into class_contact (class_no, instructor_no, type, contact) values (4, 4, 'K', 'ruemoo1');
insert into class_price_option (class_no, opt) values (4, '커플 신청 시 각 1만원 할인');
insert into class_price_option (class_no, opt) values (4, '재수강자 1만원 할인');
insert into class_price_option (class_no, opt) values (4, '중복할인 불가');

-- 5
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('B', 'HD', 'P', null, 4, 3, 'AHORA 바차타 수료식반', '2018-11-03', '2018-11-24', '총 4주, 매주 토요일', '16:00', '18:00', '홍대클럽텐션', 60000, 60000, 'NH농협 010-7290-9770-19 유무형', 'class_4.jpg');
insert into class_contact (class_no, instructor_no, type, contact) values (5, 4, 'P', '010-7290-9770');
insert into class_price_option (class_no, opt) values (5, '기수강자에 한해 커플당 1만원 할인');

-- 6
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('B', 'HD', 'N', null, 5, 3, '10% BACHATA 태수&스칼렛', '2019-01-12', '2019-02-23', '총 6주, 매주 토요일', '18:00', '19:00', '댄싱아일랜드', 100000, 100000, '하나은행 549-910154-52007 박성찬', 'class_5.jpg');
insert into class_contact (class_no, instructor_no, type, contact) values (6, 5, 'P', '010-2736-2117');
insert into class_contact (class_no, instructor_no, type, contact) values (6, 3, 'P', '010-2335-8364');
insert into class_date_option (class_no, opt) values (6, '1/19 휴강(부산 워크샵)');
insert into class_price_option (class_no, opt) values (6, '클래스 1+2 동시수강 5만원 할인');
insert into class_price_option (class_no, opt) values (6, '12/31까지 등록 시 1만원 할인');
insert into class_price_option (class_no, opt) values (6, '2인 이상 동시 등록 시 1만원 할인');
insert into class_price_option (class_no, opt) values (6, '중복 가능');

-- 7
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('B', 'HD', 'N', null, 5, 3, '10% BACHATA 태수&스칼렛', '2019-01-12', '2019-02-23', '총 6주, 매주 토요일', '19:00', '20:00', '댄싱아일랜드', 100000, 100000, '하나은행 549-910154-52007 박성찬', 'class_5.jpg');
insert into class_contact (class_no, instructor_no, type, contact) values (7, 5, 'P', '010-2736-2117');
insert into class_contact (class_no, instructor_no, type, contact) values (7, 3, 'P', '010-2335-8364');
insert into class_date_option (class_no, opt) values (7, '1/19 휴강(부산 워크샵)');
insert into class_price_option (class_no, opt) values (7, '클래스 1+2 동시수강 5만원 할인');
insert into class_price_option (class_no, opt) values (7, '12/31까지 등록 시 1만원 할인');
insert into class_price_option (class_no, opt) values (7, '2인 이상 동시 등록 시 1만원 할인');
insert into class_price_option (class_no, opt) values (7, '중복 가능');

-- 8
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('S', 'HD', 'N', null, 6, 3, '살사 실전패턴 파트너쉽 스타일링', '2019-01-04', '2019-02-08', '총 6주, 매주 금요일', '20:00', '21:00', '부에나', 120000, 120000, '카카오뱅크 3333-08-7969093 정해영', 'class_6.jpg');
insert into class_contact (class_no, instructor_no, type, contact) values (8, 6, 'P', '010-4929-8603');
insert into class_contact (class_no, instructor_no, type, contact) values (8, 6, 'K', 'silver1982');
insert into class_contact (class_no, instructor_no, type, contact) values (8, 3, 'P', '010-2335-8364');
insert into class_contact (class_no, instructor_no, type, contact) values (8, 3, 'K', 'ssg8364');
insert into class_price_option (class_no, opt) values (8, '12/20까지 등록 시 1만원 할인');
insert into class_price_option (class_no, opt) values (8, '동반신청 시 1만원 할인');

-- 9
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('S', 'BD', 'N', null, 7, 3, '[스칼렛 & 리키쌤] 살사 왕초급', '2019-01-09', '2019-02-27', '총 8주, 매주 수요일', '18:30', '19:30', '실루엣', 120000, 120000, null, 'class_7.jpg');
insert into class_contact (class_no, instructor_no, type, contact) values (9, null, null, '구슬 010.2727.1501');
insert into class_price_option (class_no, opt) values (9, '동시강습 시 할인');

-- 10
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('S', 'BD', 'N', null, 7, 3, '[스칼렛 & 리키쌤] 살사 초급', '2019-01-09', '2019-02-27', '총 8주, 매주 수요일', '19:30', '20:30', '실루엣', 120000, 120000, null, 'class_7.jpg');
insert into class_contact (class_no, instructor_no, type, contact) values (10, null, null, '구슬 010.2727.1501');
insert into class_price_option (class_no, opt) values (10, '동시강습 시 할인');

-- 11
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('B', 'BD', 'N', null, 7, 3, '[스칼렛 & 리키쌤] 센슈얼 바차타', '2019-01-09', '2019-02-27', '총 8주, 매주 수요일', '20:30', '21:30', '실루엣', 120000, 120000, null, 'class_7.jpg');
insert into class_contact (class_no, instructor_no, type, contact) values (11, null, null, '구슬 010.2727.1501');
insert into class_price_option (class_no, opt) values (11, '동시강습 시 할인');

-- 12
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('S', 'BD', 'N', null, 7, 3, '[스칼렛 & 리키쌤] 살사 초중급', '2019-01-09', '2019-02-27', '총 8주, 매주 수요일', '21:30', '22:30', '실루엣', 120000, 120000, null, 'class_7.jpg');
insert into class_contact (class_no, instructor_no, type, contact) values (12, null, null, '구슬 010.2727.1501');
insert into class_price_option (class_no, opt) values (12, '동시강습 시 할인');

-- 13
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('B', 'HD', 'N', null, 4, null, '베이직의 원리와 무브의 이해', '2018-12-29', '2019-01-26', '총 5주, 매주 토요일', '16:30', '18:00', '홍대클럽 텐션 B홀', 70000, 50000, 'NH농협 010-7290-9770-19 유무형', 'class_8.jpg');
insert into class_contact (class_no, instructor_no, type, contact) values (13, 4, 'P', '010-7290-9770');
insert into class_contact (class_no, instructor_no, type, contact) values (13, 4, 'K', 'ruemoo1');
insert into class_price_option (class_no, opt) values (13, '재수강자, 커플등록, 소개자 각 1만원 할인');
insert into class_price_option (class_no, opt) values (13, '중복할인 불가');

-- 14
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('B', 'GN', 'O', null, 8, 3, '센슈얼 바차타 오픈강습', '2019-01-02', '2019-01-02', null, '20:00', '21:00', '우노 살사클럽', 10000, 10000, null, 'class_9.jpg');

-- 15
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('B', 'GN', 'O', null, 8, 3, '센슈얼 바차타 오픈강습', '2019-01-09', '2019-01-09', null, '20:00', '21:00', '우노 살사클럽', 10000, 10000, null, 'class_9.jpg');

-- 16
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('B', 'AP', 'N', null, 3, null, '스칼렛쌤 살사&바차타 무브먼트 레벨1', '2019-01-04', '2019-02-08', '총 6주, 매주 금요일', '20:00', '21:00', '클럽 TOP', 90000, 90000, null, 'class_10.jpg');
insert into class_contact (class_no, instructor_no, type, contact) values (16, null, null, '탁이(010-2237-0009)');

-- 17
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('S', 'HD', 'N', null, 6, 3, '살사 실전패턴반', '2019-01-12', '2019-02-23', '총 6주, 매주 토요일', '17:00', '18:00', '아일랜드 스튜디오', 70000, 70000, '카카오뱅크 3333-08-7969093 정해영', 'class_11.jpg');
insert into class_price_option (class_no, opt) values (17, '동시수강 1만원 할인(바차타)');
insert into class_price_option (class_no, opt) values (17, '동반신청 1만원 할인');
insert into class_contact (class_no, instructor_no, type, contact) values (17, 6, 'P', '010-4929-8603');
insert into class_contact (class_no, instructor_no, type, contact) values (17, 6, 'K', 'silver1982');
insert into class_contact (class_no, instructor_no, type, contact) values (17, 3, 'P', '010-2335-8364');
insert into class_contact (class_no, instructor_no, type, contact) values (17, 3, 'K', 'ssg8364');

-- 18
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('B', 'GN', 'N', 'F', 9, 10, '바차타 레이디 샤인', '2019-02-10', '2019-03-24', '총 7주, 매주 요일', '17:00', '18:30', '턴바 3층 A홀', 0, 150000, '신한은행 110-498-700466 오혜린', 'class_12.jpg');
insert into class_contact (class_no, instructor_no, type, contact) values (18, 9, 'P', '010-4617-8364');
insert into class_contact (class_no, instructor_no, type, contact) values (18, 10, 'P', '010-4738-5380');

-- 19
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('H', 'HD', 'N', null, 10, null, '부갈루+힙합 퓨전 샤인', '2019-02-10', '2019-03-24', '총 7주, 매주 토요일', '19:00', '20:30', '홍대 연습실', 150000, 150000, '신한은행 110-498-700466 오혜린', 'class_13.jpg');
insert into class_contact (class_no, instructor_no, type, contact) values (19, 10, 'P', '010-4738-5380');

-- 20
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('B', 'HD', 'N', null, 5, 3, 'AHORA 10% BACHATA', '2019-01-31', '2019-03-07', '총 6주, 매주 목요일', '19:50', '21:30', '텐션', 200000, 200000, '하나은행 549-910154-52007 박성찬', 'class_14.jpg');
insert into class_contact (class_no, instructor_no, type, contact) values (20, 5, 'P', '010-2736-2117');
insert into class_contact (class_no, instructor_no, type, contact) values (20, 3, 'P', '010-2335-8364');
insert into class_price_option (class_no, opt) values (20, '패밀리가 17만원');
insert into class_price_option (class_no, opt) values (20, '현 수강자 15만원');

-- 21
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('B', 'HD', 'N', null, 4, null, '딥패턴의 필수 기초', '2019-01-15', '2019-02-19', '총 5주, 매주 화요일', '20:00', '21:00', '텐션 A홀', 70000, 50000, 'NH농협 010-7290-9770-19 유무형', 'class_15.jpg');
insert into class_price_option (class_no, opt) values (21, '재수강 - 1만원 할인');
insert into class_price_option (class_no, opt) values (21, '커플신청 - 각각 1만원 할인');
insert into class_price_option (class_no, opt) values (21, '신규소개 - 소개하신 분과 받으신 분 모두 50% 할인');
insert into class_date_option (class_no, opt) values (21, '설연휴 휴강');
insert into class_contact (class_no, instructor_no, type, contact) values (21, 4, 'P', '010-9219-9770');

-- 22
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('B', 'HD', 'N', null, 4, null, '토요일 베이직 클래스', '2019-02-02', '2019-03-02', '총 5주, 매주 토요일', '17:30', '19:00', '텐션', 70000, 50000, 'NH농협 010-7290-9770-19 유무형', 'class_16.jpg');
insert into class_price_option (class_no, opt) values (22, '커플신청, 지인소개, 재수강 시 1만원 할인');
insert into class_price_option (class_no, opt) values (22, '중복할인 불가');
insert into class_contact (class_no, instructor_no, type, contact) values (22, 4, 'P', '010-9219-9770');
insert into class_contact (class_no, instructor_no, type, contact) values (22, 4, 'K', 'ruemoo1');

-- 23
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('B', 'HD', 'N', null, 4, null, '토요반 바차타 베이직+무브먼트', '2019-05-04', '2019-06-01', '총 5주, 매주 토요일', '17:30', '19:00', '텐션 메인홀', 60000, 60000, 'NH농협 010-7290-9770-19 유무형', 'class_17.jpg');
insert into class_price_option (class_no, opt) values (23, '재수강, 커플등록 시 1만원 할인');
insert into class_price_option (class_no, opt) values (23, '중복할인 X');
insert into class_contact (class_no, instructor_no, type, contact) values (23, 4, 'P', '010-9219-9770');
insert into class_contact (class_no, instructor_no, type, contact) values (23, 4, 'K', 'ruemoo1');

-- 24
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('S', 'HD', 'N', null, 4, null, '토요반 살사 베이직+무브먼트', '2019-05-04', '2019-06-01', '총 5주, 매주 토요일', '20:00', '21:00', '텐션 메인홀', 40000, 40000, 'NH농협 010-7290-9770-19 유무형', 'class_17.jpg');
insert into class_price_option (class_no, opt) values (24, '재수강, 커플등록 시 1만원 할인');
insert into class_price_option (class_no, opt) values (24, '중복할인 X');
insert into class_contact (class_no, instructor_no, type, contact) values (24, 4, 'P', '010-9219-9770');
insert into class_contact (class_no, instructor_no, type, contact) values (24, 4, 'K', 'ruemoo1');

-- 25
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('B', 'HD', 'N', null, 4, 11, '바차타 핫 데이', '2019-04-04', '2019-05-02', '총 5주, 매주 목요일', '20:30', '21:30', '텐션 메인홀', 60000, 30000, 'NH농협 010-7290-9770-19 유무형', 'class_18.jpg');
insert into class_price_option (class_no, opt) values (25, '커플신청 각각 1만원 할인');
insert into class_contact (class_no, instructor_no, type, contact) values (25, 4, 'P', '010-9219-9770');
insert into class_contact (class_no, instructor_no, type, contact) values (25, 4, 'K', 'ruemoo1');

-- 26
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('B', 'GN', 'N', null, 12, 3, 'Ahora Bachata Class1', '2019-03-14', '2019-04-25', '총 7주, 매주 목요일', '19:00', '20:00', '웨스티스', 100000, 100000, '우리은행 180-08-244668 전신영', 'class_19.jpg');
insert into class_contact (class_no, instructor_no, type, contact) values (26, 3, 'P', '010-2335-8364');
insert into class_price_option (class_no, opt) values (26, '클래스 1,2 동시 수강자 15만원');
insert into class_price_option (class_no, opt) values (26, '단, 기수강자는 50% 할인');

-- 27
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('B', 'GN', 'N', null, 12, 3, 'Ahora Bachata Class2', '2019-03-14', '2019-04-25', '총 7주, 매주 목요일', '20:10', '21:10', '웨스티스', 100000, 100000, '우리은행 180-08-244668 전신영', 'class_19.jpg');
insert into class_contact (class_no, instructor_no, type, contact) values (27, 3, 'P', '010-2335-8364');
insert into class_price_option (class_no, opt) values (27, '클래스 1,2 동시 수강자 15만원');
insert into class_price_option (class_no, opt) values (27, '단, 기수강자는 50% 할인');

-- 28
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('S', 'HD', 'N', null, 13, 3, '[아오라 홍대 토요클래스] 살사 안무발표반', '2019-04-27', '2019-06-15', '총 7주, 매주 토요일', '18:00', '20:00', '댄싱 아일랜드', 150000, 150000, '우리은행 180-08-244668 전신영', 'class_21.jpg');
insert into class_price_option (class_no, opt) values (28, '아오라 수업 기수강자 2만원 할인');
insert into class_price_option (class_no, opt) values (28, '커플신청 시 각 1만원 할인');
insert into class_price_option (class_no, opt) values (28, '위 조건 모두 충족 시 중복할인 가능');
insert into class_price_option (class_no, opt) values (28, '바차타 반과 동시 수강 시 - 수강료 10만원');
insert into class_date_option (class_no, opt) values (28, '5/11은 강사 스케쥴로 연습데이 진행');
insert into class_contact (class_no, instructor_no, type, contact) values (28, 3, 'P', '010-2335-8364');
insert into class_contact (class_no, instructor_no, type, contact) values (28, 3, 'K', 'ssg8364');

-- 29
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('B', 'HD', 'N', null, 14, 3, '[아오라 홍대 토요클래스] 바차타 한곡완성반', '2019-04-27', '2019-06-15', '총 7주, 매주 토요일', '16:00', '18:00', '댄싱 아일랜드', 150000, 150000, '우리은행 180-08-244668 전신영', 'class_22.jpg');
insert into class_price_option (class_no, opt) values (29, '아오라 수업 모든 기수강자 2만원 할인');
insert into class_price_option (class_no, opt) values (29, '커플신청 시 각 1만원 할인');
insert into class_price_option (class_no, opt) values (29, '위 조건 모두 충족 시 중복할인 가능');
insert into class_price_option (class_no, opt) values (29, '살사 반과 동시 수강 시 - 수강료 10만원');
insert into class_date_option (class_no, opt) values (29, '5/11은 연습데이 진행');
insert into class_contact (class_no, instructor_no, type, contact) values (29, 3, 'P', '010-2335-8364');
insert into class_contact (class_no, instructor_no, type, contact) values (29, 3, 'K', 'ssg8364');

-- 30
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('S', 'HD', 'C', null, 14, 15, '[아오라 홍대 목요일 클래스] Salsa 클리닉', '2019-05-02', '2019-06-13', '총 7주, 매주 목요일', '19:00', '20:00', '웨스티스', 80000, 80000, '우리은행 180-08-244668 전신영', 'class_23.jpg');
insert into class_price_option (class_no, opt) values (30, '패턴집중반과 동시 수강 시 12만원');
insert into class_price_option (class_no, opt) values (30, '단, 기수강자는 50% 할인');
insert into class_contact (class_no, instructor_no, type, contact) values (30, 14, 'P', '010-2550-8864');
insert into class_contact (class_no, instructor_no, type, contact) values (30, 15, 'P', '010-7900-2007');

-- 31
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('S', 'HD', 'N', null, 14, 15, '[아오라 홍대 목요일 클래스] Salsa 패턴집중반', '2019-05-02', '2019-06-13', '총 7주, 매주 목요일', '20:10', '21:10', '웨스티스', 80000, 80000, '우리은행 180-08-244668 전신영', 'class_23.jpg');
insert into class_price_option (class_no, opt) values (31, '클리닉반과 동시 수강 시 12만원');
insert into class_price_option (class_no, opt) values (31, '단, 기수강자는 50% 할인');
insert into class_contact (class_no, instructor_no, type, contact) values (31, 14, 'P', '010-2550-8864');
insert into class_contact (class_no, instructor_no, type, contact) values (31, 15, 'P', '010-7900-2007');

-- 32
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('B', 'HD', 'N', null, 12, 3, '[AHORA Bachata] 목요일 강남클래스 시즌2 클래스1', '2019-05-02', '2019-06-13', '총 7주, 매주 목요일', '19:00', '20:00', '웨스티스', 100000, 100000, '우리은행 180-08-244668 전신영', 'class_24.jpg');
insert into class_price_option (class_no, opt) values (32, '클래스 1,2 동시 수강자 15만원');
insert into class_price_option (class_no, opt) values (32, '단, 기수강자는 50% 할인');
insert into class_contact (class_no, instructor_no, type, contact) values (32, 3, 'P', '010-2335-8364');
insert into class_contact (class_no, instructor_no, type, contact) values (32, 3, 'K', 'ssg8364');

-- 33
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('B', 'HD', 'N', null, 12, 3, '[AHORA Bachata] 목요일 강남클래스 시즌2 클래스2', '2019-05-02', '2019-06-13', '총 7주, 매주 목요일', '20:10', '21:10', '웨스티스', 100000, 100000, '우리은행 180-08-244668 전신영', 'class_24.jpg');
insert into class_price_option (class_no, opt) values (33, '클래스 1,2 동시 수강자 15만원');
insert into class_price_option (class_no, opt) values (33, '단, 기수강자는 50% 할인');
insert into class_contact (class_no, instructor_no, type, contact) values (33, 3, 'P', '010-2335-8364');
insert into class_contact (class_no, instructor_no, type, contact) values (33, 3, 'K', 'ssg8364');

-- 34
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('B', 'HD', 'N', null, 16, null, '[이소] 스타일링n무브먼트', '2019-06-06', '2019-06-27', '총 4주, 매주 목요일', '19:30', '20:30', '홍대클럽 텐션', 50000, 50000, '우리은행 100-25-11074916 이소정', 'class_25.jpg');
insert into class_contact (class_no, instructor_no, type, contact) values (34, 16, 'P', '010-9914-1985');

-- 35
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image)
values ('S', 'GD', 'N', null, 17, 2, '[라틴댄스 동호회 아댄스] SALSA ON2 초급반', '2019-05-03', '2019-06-07', '총 6주, 매주 금요일', '20:00', '21:00', '스윙트리바', 60000, 60000, '카카오뱅크 3333-06-4353833 김희경', 'class_26.jpg');
insert into class_price_option (class_no, opt) values (35, '강습 후 정모비 별도');
insert into class_contact (class_no, instructor_no, type, contact) values (35, null, null, '010-8332-9580');

-- 36
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image, club_no)
values ('S', 'GD', 'N', null, 17, 2, '[라틴댄스 동호회 아댄스] SALSA ON2 초중급반', '2019-06-21', '2019-07-26', '총 6주, 매주 금요일', '20:00', '21:00', '스윙트리바', 70000, 70000, '카카오뱅크 3333-06-4353833 김희경', 'class_27.jpg', 2);
insert into class_price_option (class_no, opt) values (36, '개강 후 환불 불가');
insert into class_contact (class_no, instructor_no, type, contact) values (36, null, null, '010-8332-9580');

-- 37
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image, club_no)
values ('B', 'GN', 'N', null, 12, 3, '[AHORA Bachata] 목요일 강남클래스 시즌3 클래스1', '2019-06-27', '2019-08-08', '총 6주, 매주 목요일', '19:30', '20:30', '웨스티스', 100000, 100000, '우리은행 180-08-244668 전신영', 'class_28.jpg', 1);
insert into class_date_option (class_no, opt) values (37, '7/18 휴강');
insert into class_price_option (class_no, opt) values (37, '클래스 1,2 동시 수강자 16만원');
insert into class_price_option (class_no, opt) values (37, '커플 신청 시 각 1만원 할인');
insert into class_price_option (class_no, opt) values (37, '단, 기수강자는 50% 할인');
insert into class_contact (class_no, instructor_no, type, contact) values (37, 3, 'P', '010-2335-8364');

-- 38
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment, class_image, club_no)
values ('B', 'GN', 'N', null, 12, 3, '[AHORA Bachata] 목요일 강남클래스 시즌3 클래스2', '2019-06-27', '2019-08-08', '총 6주, 매주 목요일', '20:30', '21:30', '웨스티스', 100000, 100000, '우리은행 180-08-244668 전신영', 'class_28.jpg', 1);
insert into class_date_option (class_no, opt) values (38, '7/18 휴강');
insert into class_price_option (class_no, opt) values (38, '클래스 1,2 동시 수강자 16만원');
insert into class_price_option (class_no, opt) values (38, '커플 신청 시 각 1만원 할인');
insert into class_price_option (class_no, opt) values (38, '단, 기수강자는 50% 할인');
insert into class_contact (class_no, instructor_no, type, contact) values (38, 3, 'P', '010-2335-8364');
