
INSERT INTO public.my_users(
	id, user_name, email_id, password)
	values(1,'user1','abc@gmail.com','abcd');



INSERT INTO public.my_users(
	id, user_name, email_id, password)
	values(2,'user2','abx@gmail.com','abcd');


insert into authority(id,name, user_name)
values(1,'ROLE_USER','user1');

insert into authority(id,name, user_name)
values(2,'ROLE_ADMIN','user2');

