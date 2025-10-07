WITH D_ORD AS ( 
  SELECT distributionorderid,
  destinationlocationid,
  distributionorderheader
  FROM distribution_order
  WHERE distributionorderheader->>'deliveryDate' > ? ),
D_ORD_ITEMS AS (
SELECT 
   distributionorderid,
   itemdata,
packid ,
status
   FROM distribution_order_item
WHERE distributionorderid in (SELECT distributionorderid from D_ORD) WWW 
)
SELECT d.distributionorderid, d.destinationlocationid , d.distributionorderheader,
doi.itemdata ,  doi.status
FROM D_ORD d , D_ORD_ITEMS doi
WHERE d.distributionorderid = doi.distributionorderid;