SELECT COUNT(*) AS FISH_COUNT
FROM FISH_NAME_INFO I
JOIN FISH_INFO N ON I.FISH_TYPE = N.FISH_TYPE
WHERE I.FISH_NAME IN ('BASS', 'SNAPPER')