insert into user (nickname, sex, instructor) values ('브라우니', 'M', false); -- 1
insert into user (nickname, sex, instructor) values ('칼리', 'F', false ); -- 2

insert into user (nickname, sex, instructor, account) values ('스칼렛', 'M', true , '우리은행 180-08-244668 전신영'); -- 3
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

-- 1
insert into class(genre, region, type, only, instructor_no_1, instructor_no_2, title, start_date, end_date, start_time, end_time, location, male_price, female_price, payment_type, payment, level, recruitment_type, recruitment_number, contents, class_image)
values ('B', 'HD', 'P', 'F', 3, null, 'Team Ahora Ladies', '2018-10-13', '2018-11-24', '19:30', '21:00', '텐션', 0, 120000, 1, null, null, null, null, null, null);
insert into class_contact (class_no, instructor_no, type, contact) values (1, 3, 'P', '010-2335-8364');
insert into class_contact (class_no, instructor_no, type, contact) values (1, 3, 'K', 'ssg8364');
insert into class_date_option (class_no, opt) values (1, '해외 워크샵 휴강(10.27)');
insert into class_price_option (class_no, opt) values (1, '기수강자, 2인 이상 신청 시 2만원 할인');
insert into class_price_option (class_no, opt) values (1, '중복할인 불가');
-- insert into class_earlybird (class_no, deadline, amount) values (1, '2019-03-15', 5000);
-- insert into class_earlybird (class_no, deadline, amount) values (1, '2019-04-10', 10000);
