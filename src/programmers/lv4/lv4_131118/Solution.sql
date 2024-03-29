SELECT RI.REST_ID
     , RI.REST_NAME
     , RI.FOOD_TYPE
     , RI.FAVORITES
     , RI.ADDRESS
     , RR.AVG AS SCORE
  FROM REST_INFO RI
  JOIN (SELECT REST_ID, ROUND(AVG(REVIEW_SCORE), 2) AVG
          FROM REST_REVIEW
         GROUP BY REST_ID) RR 
    ON RI.REST_ID = RR.REST_ID
 WHERE ADDRESS LIKE '서울%'
 ORDER BY RR.AVG DESC, RI.FAVORITES DESC;