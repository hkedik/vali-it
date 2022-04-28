INSERT INTO public.contact (id, first_name, last_name, email, tel,                             account_number)
VALUES (DEFAULT, 'Ants', 'Tamm', 'ants@mail.ee', '456465432', 'EE987654321');

INSERT INTO public.contact (id, first_name, last_name, email, tel, account_number)
VALUES (DEFAULT, 'Anu', 'Kask', 'anu@mail.ee', '56468298','EE123456789');

INSERT INTO public.role (id, name)
VALUES (DEFAULT, 'admin');

INSERT INTO public.role (id, name)
VALUES (DEFAULT, 'teacher');

INSERT INTO public.role (id, name)
VALUES (DEFAULT, 'parent');

INSERT INTO public.group_info (id, group_name, description, date_time)
VALUES (DEFAULT, 'Lumehelbeke', 'Lasteaed Maasikas', '2017-04-20');

INSERT INTO public.student (id, group_info_id, first_name, last_name, date_of_birth, active)
VALUES (DEFAULT, 1, 'Maris', 'Maasikas', '2017-04-20', true);

INSERT INTO public.student (id, group_info_id, first_name, last_name, date_of_birth, active)
VALUES (DEFAULT, 1, 'Mati', 'Tamm', '2016-04-13', true);

INSERT INTO public.group_balance (id, group_info_id, balance)
VALUES (DEFAULT, 1, 500.00);

INSERT INTO public.student_balance (id, group_balance_id, student_id, balance)
VALUES (DEFAULT, 1, 1, 25.00);

INSERT INTO public.student_balance (id, group_balance_id, student_id, balance)
VALUES (DEFAULT, 1, 2, 475.00);

INSERT INTO public.user_in_group (id, group_info_id, user_id, date_activated, is_active, is_moderator)
VALUES (DEFAULT, 1, 1, '2022-04-26', true, true);

INSERT INTO public.user_in_group (id, group_info_id, user_id, date_activated, is_active, is_moderator)
VALUES (DEFAULT, 1, 2, '2022-04-27', true, DEFAULT);





