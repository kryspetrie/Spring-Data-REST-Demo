DROP TABLE IF EXISTS animal_inventory;
DROP TABLE IF EXISTS zoo;
DROP TABLE IF EXISTS animal;

CREATE TABLE animal
(
    id UUID UNIQUE NOT NULL PRIMARY KEY DEFAULT gen_random_uuid(),
    updated DATE NOT NULL DEFAULT now(),
    name TEXT NOT NULL,
    description TEXT NOT NULL,
    conservation_status TEXT NOT NULL
);

CREATE TABLE zoo
(
    id UUID UNIQUE NOT NULL PRIMARY KEY DEFAULT gen_random_uuid(),
    updated DATE NOT NULL DEFAULT now(),
    name TEXT NOT NULL,
    location TEXT NOT NULL
);

CREATE TABLE animal_inventory
(
    id UUID UNIQUE NOT NULL PRIMARY KEY DEFAULT gen_random_uuid(),
    updated DATE NOT NULL DEFAULT now(),
    animal_id UUID references animal(id),
    zoo_id UUID references zoo(id),
    sex_male INT NOT NULL,
    sex_female INT NOT NULL,
    sex_unknown INT NOT NULL
);

INSERT into animal(id, name, description, conservation_status)
VALUES
('7583728d-6193-404d-b8d6-17cf9f9e3640'::uuid, 'Cat', 'A furry feline with a scratchy disposition.', 'Least Concern'),
('6b3b533b-a620-41ea-bf9f-1d888b1d4777'::uuid, 'Eastern Gray Wolf', 'A fluffy canine with big teeth.', 'Threatened'),
('0a510c8a-f3aa-4690-84f4-cdafccc589fa'::uuid, 'Parasaurolophus', 'A big honky boy from olden times.', 'Extinct');

INSERT INTO zoo(id, name, location)
VALUES
('4867473c-c1be-4801-8317-1f72ae7fa9ae'::uuid, 'My House', 'Waltham, MA'),
('ab8b78bd-bf29-4658-9104-7244d37e4ddc'::uuid, 'Wolf Hollow', 'Ipswich, MA'),
('636f643c-c494-45bc-bc45-eadcd9d6d6e8'::uuid, 'Dinosaur World', 'Florida');

INSERT INTO animal_inventory(animal_id, zoo_id, sex_male, sex_female, sex_unknown)
VALUES
('7583728d-6193-404d-b8d6-17cf9f9e3640'::uuid, '4867473c-c1be-4801-8317-1f72ae7fa9ae'::uuid, 1, 0, 0),
('6b3b533b-a620-41ea-bf9f-1d888b1d4777'::uuid, 'ab8b78bd-bf29-4658-9104-7244d37e4ddc'::uuid, 4, 4, 0),
('0a510c8a-f3aa-4690-84f4-cdafccc589fa'::uuid, '636f643c-c494-45bc-bc45-eadcd9d6d6e8'::uuid, 0, 0, 1),
('7583728d-6193-404d-b8d6-17cf9f9e3640'::uuid, '636f643c-c494-45bc-bc45-eadcd9d6d6e8'::uuid, 0, 1, 0);
