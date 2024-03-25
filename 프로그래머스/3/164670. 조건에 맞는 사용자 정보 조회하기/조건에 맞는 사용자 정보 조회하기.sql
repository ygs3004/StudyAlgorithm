SELECT UGU.USER_ID
     , UGU.NICKNAME
     , CONCAT(
               UGU.CITY
              , ' '
              , UGU.STREET_ADDRESS1
              , ' '
              , UGU.STREET_ADDRESS2
              ) AS 전체주소
     , CONCAT ( 
                SUBSTRING(UGU.TLNO, 1, 3)
              , '-'
              , SUBSTRING(UGU.TLNO, 4, 4)
              , '-'
              , SUBSTRING(UGU.TLNO, 8, 4)
              ) AS 전화번호
  FROM USED_GOODS_BOARD UGB
  JOIN USED_GOODS_USER UGU ON UGB.WRITER_ID = UGU.USER_ID
 GROUP BY UGU.USER_ID
HAVING COUNT(*) >= 3
ORDER BY USER_ID DESC;