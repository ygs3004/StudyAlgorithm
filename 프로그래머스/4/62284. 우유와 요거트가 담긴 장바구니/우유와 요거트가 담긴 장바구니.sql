SELECT M.CART_ID
  FROM CART_PRODUCTS M
 WHERE EXISTS (SELECT 1 
                 FROM CART_PRODUCTS S
                WHERE M.CART_ID = S.CART_ID
                  AND S.NAME = 'Yogurt')
   AND EXISTS (SELECT 1 
                 FROM CART_PRODUCTS S
                WHERE M.CART_ID = S.CART_ID
                  AND S.NAME = 'Milk')
 GROUP BY M.CART_ID
 ORDER BY M.CART_ID