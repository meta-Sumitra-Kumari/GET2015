USE library_database;
-- Query 1 to display information on books issued for more than two months

INSERT INTO book_issue (accession_no,member_id)
VALUES((SELECT accession_no FROM books where title_id=ALL(SELECT title_id FROM titles where title_nm='Operating System')),
(SELECT member_id FROM members where member_nm='sumitra'));

INSERT INTO book_return(return_dt,issue_dt,accession_no,member_id)
VALUES("2015-11-23",
(SELECT issue_dt from book_issue where member_id=3),
(SELECT accession_no FROM book_issue where member_id=3),3);
INSERT INTO book_issue (accession_no,member_id)
VALUES((SELECT accession_no FROM books where title_id=ALL(SELECT title_id FROM titles where title_nm='PAPER TOWN')),
(SELECT member_id FROM members where member_nm='sumitra'));

INSERT INTO book_issue (accession_no,member_id)
VALUES((SELECT accession_no FROM books where title_id=ALL(SELECT title_id FROM titles where title_nm='PAPER TOWN')),
(SELECT member_id FROM members where member_nm='deepali'));
 

INSERT INTO book_return(return_dt,issue_dt,accession_no,member_id)
VALUES((SELECT due_dt from book_issue where member_id =1),
(SELECT issue_dt from book_issue where member_id=1),
(SELECT accession_no FROM book_issue where member_id=1),1);

INSERT INTO book_return(return_dt,issue_dt,accession_no,member_id)
VALUES("2015-11-23",
(SELECT issue_dt from book_issue where member_id=3),
(SELECT accession_no FROM book_issue where member_id=3),3);

INSERT INTO book_return(return_dt,issue_dt,accession_no,member_id)
VALUES("2015-11-24",
(SELECT issue_dt from book_issue where member_id=4),
(SELECT accession_no FROM book_issue where member_id=4),4);
SELECT 
    m.member_nm,
    m.member_id,
    t.title_nm,
    b.accession_no,
    bi.issue_dt,
    bi.due_dt,
    (TIMESTAMPDIFF(MONTH,
        br.issue_dt,
        br.return_dt)>2)  AS months_duration
FROM
    members m,
    titles t,
    books b,
    book_return br,
    book_issue bi
WHERE
    m.member_id = bi.member_id && bi.accession_no = b.accession_no && b.title_id = t.title_id && m.member_id = br.member_id && b.status = 0;
   
   -- Query 2 to display name with maximum characters along with length
SELECT 
    member_nm, CHAR_LENGTH(member_nm) AS Length
FROM
    members
WHERE
    CHAR_LENGTH(member_nm) = (SELECT 
        max(CHAR_LENGTH(member_nm))
    FROM
        members);
        -- Query 3 to display number of books issued till date
SELECT 
    COUNT(DISTINCT accession_no) AS No_Of_Books_Issued
FROM
    books;
    -- Query 4 to display subject wise information on number of books purchased
SELECT 
    COUNT(s.subject_id) AS TOTAL_BOOKS,
    s.subject_id,
    s.subject_nm
FROM
    books b
        INNER JOIN
    titles t
        INNER JOIN
    subjects s
WHERE
    ((b.title_id = t.title_id) AND (t.subject_id = s.subject_id))
GROUP BY s.subject_id ;
-- Query 5 to display number of books returned after 2 months
SELECT 
    *
FROM
    book_issue bi
WHERE
    (DATEDIFF(bi.due_dt, bi.issue_dt)/30) > 2;
    -- Query 6 to display books having price greater than minimum price
SELECT 
    title_nm
FROM
    titles t,
    books b1
WHERE
    t.title_id = b1.title_id && b1.price > (SELECT 
        MIN(b.price)
    FROM
        books b);
        ALTER TABLE members ADD person_type char;

Update Members Set person_type='S' where member_id=1;
Update Members Set person_type='O' where member_id=2;
Update Members Set person_type='P' where member_id=3;
Update Members Set person_type='S' where member_id=4;
Update Members Set person_type='P' where member_id=5;
        -- Query 7 to display number of types of members in library management system
SELECT 
    COUNT(if(person_type = 'P', person_type, null)) AS NO_OF_PROFESSORS,
    COUNT(if(person_type = 'S', person_type, null)) AS NO_OF_STUDENTS,
    COUNT(if(person_type = 'O', person_type, null)) AS NO_OF_OTHERS
FROM
    members;
    -- Query 8 to display information of those titles issued for 2 or more than 2 times
SELECT 
    t.title_id, t.title_nm, t.subject_id, t.publisher_id
FROM
    titles t,
    books b,
    book_issue bi
where
    (bi.accession_no = b.accession_no AND b.title_id = t.title_id)
group by bi.accession_no
HAVING (count(bi.accession_no) >= 2);

-- Query 9 to display books issued to members other than type faculty
SELECT 
    b.accession_no as accession_no,
    b.title_id as title_id,
    b.purchase_dt as purchase_date,
    b.price as price
FROM
    books b,
    members m,
    book_issue bi
WHERE
    bi.member_id = m.member_id AND m.person_type != 'P' AND bi.accession_no = b.accession_no AND b.status = 1;

-- Query 10 to display information of those authors whose book has been purchased at least
SELECT 
    b.accession_no as accession_no,
    a.author_nm as author_name,
    t.title_nm as title_name
FROM
    books b,
    title_author ta,
    authors a,
    titles t
WHERE
    a.author_id = ta.author_id AND ta.title_id = b.title_id AND b.title_id = t.title_id;
