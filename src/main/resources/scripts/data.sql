create table driver
(
    id uuid not null
        constraint driver_pkey
            primary key,
    created_at timestamp,
    full_name varchar(255),
    location varchar(255),
    plate_number varchar(255),
    state varchar(255),
    updated_at timestamp
);

alter table driver owner to postgres;

create table rider
(
    id uuid not null
        constraint rider_pkey
            primary key,
    created_at timestamp,
    full_name varchar(255),
    location varchar(255),
    updated_at timestamp
);

alter table rider owner to postgres;

create table trip
(
    id uuid not null
        constraint trip_pkey
            primary key,
    created_at timestamp,
    destination_location varchar(255),
    from_location varchar(255),
    state varchar(255),
    updated_at timestamp,
    driver_id uuid
        constraint fkpuhkx68hnwy4by2b0onybv5x1
            references driver,
    rider_id uuid
        constraint fkadis30niu5ow1yxq1a5qrsguw
            references rider
);

alter table trip owner to postgres;







INSERT INTO public.driver (id,created_at,full_name,"location",plate_number,state,updated_at) VALUES
('17b89c8f-330a-44b8-a566-b50dd4dda39f'::uuid,'2021-06-24 02:52:29.623','full name 1','0,0','RAF124A','AVAILABLE','2021-06-24 02:52:29.623'),
('be919e4c-78c2-43ca-aac8-ab4663cba10a'::uuid,'2021-06-24 02:52:29.623','full name 2','0,0','RAF125A','AVAILABLE','2021-06-24 02:52:29.623'),
('f0d38076-6f98-4e34-bd53-2c94b2d149f1'::uuid,'2021-06-24 02:52:29.631','full name 3','0,0','RAF126A','AVAILABLE','2021-06-24 02:52:29.631'),
('8aea87bf-6695-410f-b131-69898de87577'::uuid,'2021-06-24 02:52:29.631','full name 4','0,0','RAF127A','AVAILABLE','2021-06-24 02:52:29.631'),
('f5d6a17d-8eaf-48ca-bd1e-3bcdf0eeda7c'::uuid,'2021-06-24 02:52:29.631','full name 5','0,0','RAF128A','AVAILABLE','2021-06-24 02:52:29.631'),
('9391c47b-083b-4920-9f96-95ba159723f3'::uuid,'2021-06-24 02:52:29.631','full name 6','0,0','RAF129A','AVAILABLE','2021-06-24 02:52:29.631'),
('66391f0f-6898-4b67-8e8d-80d0496b34ce'::uuid,'2021-06-24 02:52:29.640','full name 7','0,0','RAF130A','AVAILABLE','2021-06-24 02:52:29.640'),
('c9298d69-68b0-4e7a-b936-ec0e079e7c1f'::uuid,'2021-06-24 02:52:29.640','full name 8','0,0','RAF131A','AVAILABLE','2021-06-24 02:52:29.640'),
('3093311f-00de-46c9-a4b2-426f4cf16604'::uuid,'2021-06-24 02:52:29.640','full name 9','0,0','RAF132A','AVAILABLE','2021-06-24 02:52:29.640'),
('bdd71496-2217-4461-a5ff-ef1f107432e6'::uuid,'2021-06-24 02:52:29.640','full name 10','0,0','RAF133A','AVAILABLE','2021-06-24 02:52:29.640');


INSERT INTO public.rider (id,created_at,full_name,"location",updated_at) VALUES
('f9f6ed5f-8ce5-4a52-b6ca-d39b39c061fe'::uuid,'2021-06-24 08:41:55.320','rider name 1','16,64','2021-06-24 08:41:55.320'),
('48e0674f-ce18-48c4-93bd-b138b39b0784'::uuid,'2021-06-24 08:41:55.344','rider name 2','17,63','2021-06-24 08:41:55.344'),
('afd1f854-8662-491b-abbf-6384f1fb0164'::uuid,'2021-06-24 08:41:55.344','rider name 3','18,62','2021-06-24 08:41:55.344'),
('a5b7d005-36b9-45b0-a131-f1384a5b95c3'::uuid,'2021-06-24 08:41:55.344','rider name 4','19,61','2021-06-24 08:41:55.344'),
('a631cf5f-9232-4a20-8cf4-3d140b1fcb8b'::uuid,'2021-06-24 08:41:55.344','rider name 5','20,60','2021-06-24 08:41:55.344'),
('d6c7f25c-e205-4ec6-89ea-a9ccb1ffa2da'::uuid,'2021-06-24 08:41:55.344','rider name 6','21,59','2021-06-24 08:41:55.344'),
('6fc72b06-5cd5-48f3-95cb-ce21b4a93d52'::uuid,'2021-06-24 08:41:55.344','rider name 7','22,58','2021-06-24 08:41:55.344'),
('ff81da53-42ff-4040-8a75-77f52b375075'::uuid,'2021-06-24 08:41:55.344','rider name 8','23,57','2021-06-24 08:41:55.344'),
('841c4349-418d-4271-9cc9-69549f88182f'::uuid,'2021-06-24 08:41:55.344','rider name 9','24,56','2021-06-24 08:41:55.344'),
('104a8e8e-b511-4f77-a582-a346a7f7f766'::uuid,'2021-06-24 08:41:55.360','rider name 10','25,55','2021-06-24 08:41:55.360');

INSERT INTO public.trip (id,created_at,destination_location,from_location,state,updated_at,driver_id,rider_id) VALUES
('6d03b2f2-f53b-4130-8532-072ead8efeca'::uuid,'2021-06-24 09:21:52.406','23,54','18,62','ACTIVE','2021-06-24 09:21:52.406','be919e4c-78c2-43ca-aac8-ab4663cba10a'::uuid,'afd1f854-8662-491b-abbf-6384f1fb0164'::uuid),
('6fc72b06-5cd5-48f3-95cb-ce21b4a93d52'::uuid,'2021-06-24 09:21:52.406','24,23','700,897','ACTIVE','2021-06-24 09:24:22.406','9391c47b-083b-4920-9f96-95ba159723f3'::uuid,'a631cf5f-9232-4a20-8cf4-3d140b1fcb8b'::uuid),
('bf5e6ba4-93e1-4107-86fa-53c1212701d9'::uuid,'2021-06-24 09:21:52.406','908,3','40,93','ACTIVE','2021-06-24 09:28:33.406','bdd71496-2217-4461-a5ff-ef1f107432e6'::uuid,'f9f6ed5f-8ce5-4a52-b6ca-d39b39c061fe'::uuid);