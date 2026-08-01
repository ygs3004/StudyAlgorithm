SELECT AO.ANIMAL_ID
      ,AO.NAME
  FROM ANIMAL_OUTS AO
 WHERE NOT EXISTS (
                   SELECT 1
                     FROM ANIMAL_INS AI
                    WHERE AI.ANIMAL_ID = AO.ANIMAL_ID
                  )
 ORDER BY AO.ANIMAL_ID,AO.NAME