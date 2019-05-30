insert into user (nickname, sex, instructor) values ('브라우니', 'M', false); -- 1
insert into user (nickname, sex, instructor) values ('칼리', 'F', false ); -- 2

insert into user (nickname, sex, instructor, account) values ('스칼렛', 'F', true , '우리은행 180-08-244668 전신영'); -- 3
insert into instructor_contact (instructor_no, type, contact) values (3, 'P', '010-2335-8364');
insert into instructor_contact (instructor_no, type, contact) values (3, 'K', 'ssg8364');
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
insert into user (nickname, sex, instructor, account) values ('퓨마', 'M', true , 'NH농협 010-7290-9770 유무형');
insert into instructor_contact (instructor_no, type, contact) values (4, 'P', '010-7290-9770');
insert into instructor_contact (instructor_no, type, contact) values (4, 'K', 'ruemoo1');

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

-- 11
insert into user (nickname, sex, instructor, account) values ('이소', 'F', true , null);

-- 12
insert into user (nickname, sex, instructor, account) values ('타미', 'M', true , null);

-- 13
insert into user (nickname, sex, instructor, account) values ('카를로스', 'M', true , null);

-- 14
insert into user (nickname, sex, instructor, account) values ('케르', 'M', true , null);

-- 15
insert into user (nickname, sex, instructor, account) values ('혜향', 'F', true , null);

-- 1
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, date_summary, start_time, end_time, location, male_price, female_price, payment_type, class_image)
values ('B', 'HD', 'P', 'F', 3, null, 'Team Ahora Ladies', '2018-10-13', '2018-11-24', '총 6주, 매주 토요일', '19:30', '21:00', '텐션', 0, 120000, '1', 'class_1.jpg');
insert into class_contact (class_no, instructor_no, type, contact) values (1, 3, 'P', null);
insert into class_contact (class_no, instructor_no, type, contact) values (1, 3, 'K', null);
insert into class_date_option (class_no, opt) values (1, '해외 워크샵 휴강(10.27)');
insert into class_price_option (class_no, opt) values (1, '기수강자, 2인 이상 신청 시 2만원 할인');
insert into class_price_option (class_no, opt) values (1, '중복할인 불가');
-- insert into class_earlybird (class_no, deadline, amount) values (1, '2019-03-15', 5000);
-- insert into class_earlybird (class_no, deadline, amount) values (1, '2019-04-10', 10000);

-- 2
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'HD', 'T', null, 4, 3, 'AHORA 바차타 트레이닝', '2018-10-30', '2018-11-27', '20:00', '21:00', '텐션', 70000, 50000, 'class_2.jpg');


-- 3
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'HD', 'C', null, 4, null, '센슈얼 바차타 중급 딥 패턴 클리닉', '2018-11-07', '2018-12-05', '20:00', '21:00', '홍대스튜디오(추후공지)', 60000, 40000, 'class_3.jpg');


-- 4
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'HD', 'C', null, 4, null, '센슈얼 바차타 중급 딥 패턴 클리닉', '2018-11-09', '2018-12-07', '20:00', '21:00', '홍대스튜디오(추후공지)', 60000, 40000, 'class_3.jpg');


-- 5
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'HD', 'P', null, 4, 3, 'AHORA 바차타 수료식반', '2018-11-03', '2018-11-24', '16:00', '18:00', '홍대클럽텐션', 60000, 60000, 'class_4.jpg');


-- 6
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'HD', 'N', null, 5, 3, '10% BACHATA 태수&스칼렛', '2019-01-12', '2019-02-23', '18:00', '19:00', '댄싱아일랜드', 100000, 100000, 'class_5.jpg');


-- 7
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'HD', 'N', null, 5, 3, '10% BACHATA 태수&스칼렛', '2019-01-12', '2019-02-23', '19:00', '20:00', '댄싱아일랜드', 100000, 100000, 'class_5.jpg');


-- 8
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'HD', 'N', null, 6, 3, '살사 실전패턴 파트너쉽 스타일링', '2019-01-04', '2019-02-08', '20:00', '21:00', '부에나', 100000, 100000, 'class_6.jpg');

-- 9
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'BD', 'N', null, 7, 3, '스칼렛 & 리키쌤 살사 왕초급', '2019-01-09', '2019-02-27', '18:30', '19:30', '실루엣', 120000, 120000, 'class_7.jpg');

-- 10
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'BD', 'N', null, 7, 3, '스칼렛 & 리키쌤 살사 초급', '2019-01-09', '2019-02-27', '19:30', '20:30', '실루엣', 120000, 120000, 'class_7.jpg');

-- 11
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'BD', 'N', null, 7, 3, '스칼렛 & 리키쌤 센슈얼 바차타', '2019-01-09', '2019-02-27', '20:30', '21:30', '실루엣', 120000, 120000, 'class_7.jpg');

-- 12
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'BD', 'N', null, 7, 3, '스칼렛 & 리키쌤 살사 초중급', '2019-01-09', '2019-02-27', '21:30', '22:30', '실루엣', 120000, 120000, 'class_7.jpg');

-- 13
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'HD', 'N', null, 4, null, '베이직의 원리와 무브의 이해', '2018-12-29', '2019-01-26', '16:30', '18:00', '홍대클럽 텐션 B홀', 70000, 50000, 'class_8.jpg');

-- 14
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'GN', 'O', null, 8, 3, '센슈얼 바차타 오픈강습', '2019-01-02', '2019-01-02', '20:00', '21:00', '우노 살사클럽', 10000, 10000, 'class_9.jpg');

-- 15
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'GN', 'O', null, 8, 3, '센슈얼 바차타 오픈강습', '2019-01-09', '2019-01-09', '20:00', '21:00', '우노 살사클럽', 10000, 10000, 'class_9.jpg');

-- 16
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'AP', 'N', null, 3, null, '스칼렛쌤 살사&바차타 무브먼트 레벨1', '2019-01-04', '2019-02-08', '20:00', '21:00', '클럽 TOP', 90000, 90000, 'class_10.jpg');

-- 17
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'HD', 'N', null, 6, 3, '살사 실전패턴반', '2019-01-12', '2019-02-23', '17:00', '18:00', '아일랜드 스튜디오', 70000, 70000, 'class_11.jpg');

-- 18
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'GN', 'N', 'F', 9, 10, '바차타 레이디 샤인', '2019-02-10', '2019-03-24', '17:00', '18:30', '턴바 3층 A홀', 0, 150000, 'class_12.jpg');

-- 19
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('H', 'HD', 'N', null, 10, null, '부갈루+힙합 퓨전 샤인', '2019-02-10', '2019-03-24', '19:00', '20:30', '홍대 연습실', 150000, 150000, 'class_13.jpg');

-- 20
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'HD', 'N', null, 5, 3, 'AHORA 10% BACHATA', '2019-01-31', '2019-03-07', '19:50', '21:30', '텐션', 200000, 200000, 'class_14.jpg');

-- 21
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'HD', 'N', null, 4, null, '딥패턴의 필수 기초', '2019-01-15', '2019-02-19', '20:00', '21:00', '텐션 A홀', 70000, 50000, 'class_15.jpg');

-- 22
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'HD', 'N', null, 4, null, '토요일 베이직 클래스', '2019-02-02', '2019-03-02', '17:30', '19:00', '텐션', 70000, 50000, 'class_16.jpg');

-- 23
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'HD', 'N', null, 4, null, '토요반 바차타 베이직+무브먼트', '2019-05-04', '2019-06-01', '17:30', '19:00', '텐션 메인홀', 60000, 60000, 'class_17.jpg');

-- 24
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'HD', 'N', null, 4, null, '토요반 살사 베이직+무브먼트', '2019-05-04', '2019-06-01', '20:00', '21:00', '텐션 메인홀', 40000, 40000, 'class_17.jpg');

-- 25
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'HD', 'N', null, 4, 11, '바차타 핫 데이', '2019-04-04', '2019-05-02', '20:30', '21:30', '텐션 메인홀', 60000, 30000, 'class_18.jpg');

-- 26
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'HD', 'N', null, 12, 4, 'Ahora Bachata Class1', '2019-03-14', '2019-04-25', '19:00', '20:00', '웨스티스', 100000, 100000, 'class_19.jpg');

-- 27
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'HD', 'N', null, 12, 4, 'Ahora Bachata Class2', '2019-03-14', '2019-04-25', '20:10', '21:10', '웨스티스', 100000, 100000, 'class_19.jpg');

-- 28
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'HD', 'N', null, 13, null, '힙합 티뷰론', '2019-04-13', '2019-04-13', '18:30', '20:00', '댄싱 아일랜드', 150000, 150000, 'class_20.jpg');

-- 29
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'HD', 'N', null, 13, null, '로즈 차차', '2019-04-20', '2019-04-20', '18:30', '20:00', '댄싱 아일랜드', 200000, 200000, 'class_20.jpg');

-- 30
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, class_image)
values ('B', 'HD', 'N', null, 13, 3, '살사 안무발표반', '2019-04-27', '2019-06-15', '18:00', '20:00', '댄싱 아일랜드', 150000, 150000, 'class_21.jpg');


