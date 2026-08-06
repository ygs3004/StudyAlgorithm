WITH CRH AS (
    SELECT (TO_DATE(END_DATE) - TO_DATE(START_DATE)) + 1 RENTAL_PERIOD
          ,HISTORY_ID
          ,CAR_ID
      FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
)

SELECT CRH.HISTORY_ID
      ,RENTAL_PERIOD
        * CC.DAILY_FEE
        * ((100 - COALESCE(CDP.DISCOUNT_RATE, 0)) / 100) AS FEE
  FROM CRH CRH
  JOIN CAR_RENTAL_COMPANY_CAR CC ON CC.CAR_ID = CRH.CAR_ID
  LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN CDP ON CDP.CAR_TYPE = CC.CAR_TYPE
                                                AND CASE WHEN CRH.RENTAL_PERIOD >= 90
                                                         THEN CDP.DURATION_TYPE = '90일 이상'
                                                         WHEN CRH.RENTAL_PERIOD >= 30
                                                         THEN CDP.DURATION_TYPE = '30일 이상'
                                                         WHEN CRH.RENTAL_PERIOD >= 7
                                                         THEN CDP.DURATION_TYPE = '7일 이상'
                                                         ELSE FALSE 
                                                     END     
 WHERE CC.CAR_TYPE = '트럭'
 ORDER BY FEE DESC, HISTORY_ID DESC