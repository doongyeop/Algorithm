SELECT A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, SUM(C.SALES * B.PRICE) AS TOTAL_SALES
FROM AUTHOR A
JOIN BOOK B ON A.AUTHOR_ID = B.AUTHOR_ID
JOIN BOOK_SALES C ON B.BOOK_ID = C.BOOK_ID
WHERE SUBSTRING(C.SALES_DATE, 1, 7) = '2022-01'
GROUP BY A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY
ORDER BY A.AUTHOR_ID ASC, B.CATEGORY DESC;
