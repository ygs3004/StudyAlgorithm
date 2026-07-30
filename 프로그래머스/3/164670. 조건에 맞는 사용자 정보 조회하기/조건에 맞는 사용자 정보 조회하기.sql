SELECT UGU.USER_ID
      ,UGU.NICKNAME
      ,UGU.CITY            || ' ' || 
       UGU.STREET_ADDRESS1 || ' ' || 
       UGU.STREET_ADDRESS2 AS 전체주소
      ,SUBSTR(UGU.TLNO, 1, 3) || '-' || 
       SUBSTR(UGU.TLNO, 4, 4) || '-' || 
       SUBSTR(UGU.TLNO, 8)                                    AS 전화번호
  FROM USED_GOODS_USER UGU
  JOIN (
        SELECT UGB.WRITER_ID
          FROM USED_GOODS_BOARD UGB 
         GROUP BY UGB.WRITER_ID
        HAVING COUNT(1) >= 3        
       ) UGB ON UGB.WRITER_ID = UGU.USER_ID
 ORDER BY UGU.USER_ID DESC
