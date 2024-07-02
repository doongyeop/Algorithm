-- 코드를 입력하세요
SELECT BOOK_ID, date_format(PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE FROM BOOK
WHERE CATEGORY = '인문' 
AND PUBLISHED_DATE AND YEAR(PUBLISHED_DATE) = 2021
ORDER BY PUBLISHED_DATE;