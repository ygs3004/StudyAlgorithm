SELECT CAR_ID
      ,MAX(CASE WHEN EXISTS (SELECT 1 
                           FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY CCRH2
                          WHERE CCRH2.START_DATE <= TO_DATE('2022-10-16', 'YYYY-MM-DD')
                            AND CCRH2.END_DATE >= TO_DATE('2022-10-16', 'YYYY-MM-DD')
                            AND CCRH2.HISTORY_ID = CCRH.HISTORY_ID
                        )
            THEN '대여중' 
            ELSE '대여 가능'
        END) AS AVAILABILITY
  FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY CCRH
 GROUP BY CAR_ID
 ORDER BY CAR_ID DESC