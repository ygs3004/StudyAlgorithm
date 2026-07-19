SELECT FO.ORDER_ID
      ,FO.PRODUCT_ID
      ,NVL(TO_CHAR(FO.OUT_DATE, 'YYYY-MM-DD'), '') AS OUT_DATE
      ,CASE WHEN FO.OUT_DATE <= TO_DATE('2022-05-01', 'YYYY-MM-DD')
            THEN '출고완료'
            WHEN FO.OUT_DATE IS NULL
            THEN '출고미정'
            ELSE '출고대기'
        END AS 출고여부
  FROM FOOD_ORDER FO
  ORDER BY FO.ORDER_ID;
  
  