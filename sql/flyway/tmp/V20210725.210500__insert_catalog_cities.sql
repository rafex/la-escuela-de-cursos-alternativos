SET IDENTITY_INSERT META_CATALOG ON;


INSERT INTO META_CATALOG
  (id_catalog, desc_catalog, name_catalog)
VALUES (
  2, 'list of cities in mexico','cities'
);

SET IDENTITY_INSERT META_CATALOG OFF;

--SET IDENTITY_INSERT META_CATALOG_VALUES ON;

INSERT INTO META_CATALOG_VALUES
  (value_catalog, label_catalog, status, id_catalog, id_catalog_value_rel)
VALUES
  ('AGUASCALIENTES','AGUASCALIENTES',1,2,1),
  ('San Francisco de los Romo','San Francisco de los Romo',1,2,1);

--SET IDENTITY_INSERT META_CATALOG_VALUES OFF;
