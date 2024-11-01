SELECT CAR_ID, CASE 
                    WHEN START_DATE <= '2022-10-16' AND END_DATE >= '2022-10-16' THEN '대여중'
                    ELSE '대여 가능'
                END AS AVAILABILTY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE <= '2022-10-16' AND END_DATE >= '2022-10-16'

UNION

SELECT CAR_ID, '대여 가능' AS AVAILABILTY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID NOT IN(
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE <= '2022-10-16' AND END_DATE >= '2022-10-16'
)
ORDER BY CAR_ID DESC