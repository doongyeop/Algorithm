SELECT P.PRODUCT_CODE, SUM(O.SALES_AMOUNT * P.PRICE) AS SALES
FROM OFFLINE_SALE O
JOIN PRODUCT P ON O.PRODUCT_ID = P.PRODUCT_ID
GROUP BY P.PRODUCT_CODE
ORDER BY SALES DESC, P.PRODUCT_CODE ASC;
